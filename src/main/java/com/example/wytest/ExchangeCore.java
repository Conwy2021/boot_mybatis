package com.example.wytest;


import com.example.wytest.Address;
import io.nuls.contract.sdk.Block;
import io.nuls.contract.sdk.Utils;
import io.nuls.contract.sdk.annotation.Required;
import io.nuls.contract.sdk.annotation.View;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Project ivy Developers
 * @title ExchangeCore
 */
public class ExchangeCore  {

    /* Cancelled / finalized orders, by hash. */
    private Map<String, Boolean> cancelledOrFinalized = new HashMap<String, Boolean>();

    /* Orders verified by on-chain approval (alternative to ECDSA signatures so that smart contracts can place orders directly). */
    private Map<String, Boolean> approvedOrders = new HashMap<String, Boolean>();

    /* For split fee orders, minimum required protocol maker fee, in basis points. Paid to owner (who can change it). */
    private BigInteger minimumMakerProtocolFee = new BigInteger("0");

    /* For split fee orders, minimum required protocol taker fee, in basis points. Paid to owner (who can change it). */
    private BigInteger minimumTakerProtocolFee = new BigInteger("0");

    /* Recipient of protocol fees. */
    private Address protocolFeeRecipient;

    /* EIP712 standard. */
    private static final String signedMessage = "\\x19Ethereum Signed Message:\n32";

    /* Mainnet config */
//    private Address ZERO_ADDR = new Address("NULSd6HgWSU1iR6BfNoQi85mAMT52JMFzpnok");
//
    private BigInteger ZERO = new BigInteger("0");
    /* Testnet config */
    private Address ZERO_ADDR = new Address("tNULSeBaMhZnRteniCy3UZqPjTbnWKBPHX1a5d");

    /* Inverse basis point. */
    private static final BigInteger INVERSE_BASIS_POINT = new BigInteger("10000");

    /* Token transfer proxy and user registry proxy. */
    private final Address proxy;

    public ExchangeCore(@Required Address proxyContract, @Required Address protocolFeeAddress) {
        this.proxy = proxyContract;
        this.protocolFeeRecipient = protocolFeeAddress;
    }

    /**
     * @dev Get the token proxy
     */
    @View
    public Address getProxy() {
        return proxy;
    }

    /**
     * @param newMinimumMakerProtocolFee New fee to set in basis points
     * @dev Change the minimum maker fee paid to the protocol (owner only)
     */
    public void changeMinimumMakerProtocolFee(BigInteger newMinimumMakerProtocolFee) {
        //onlyOwner();
        minimumMakerProtocolFee = newMinimumMakerProtocolFee;
    }

    /**
     * @return minimumMakerProtocolFee
     */
    @View
    public BigInteger getMinimumMakerProtocolFee() {
        return minimumMakerProtocolFee;
    }

    /**
     * @param newMinimumTakerProtocolFee New fee to set in basis points
     * @dev Change the minimum taker fee paid to the protocol (owner only)
     */
    public void changeMinimumTakerProtocolFee(BigInteger newMinimumTakerProtocolFee) {
        //onlyOwner();
        minimumTakerProtocolFee = newMinimumTakerProtocolFee;
    }

    /**
     * @return return minimumTakerProtocolFee
     */
    @View
    public BigInteger getMinimumTakerProtocolFee() {
        return minimumTakerProtocolFee;
    }

    /**
     * @param newProtocolFeeRecipient New protocol fee recipient address
     * @dev Change the protocol fee recipient (owner only)
     */
    public void changeProtocolFeeRecipient(Address newProtocolFeeRecipient) {
       // onlyOwner();
        protocolFeeRecipient = newProtocolFeeRecipient;
    }

    /**
     * @param hash order hash
     * @dev Query cancelledOrFinalized order status
     */
    @View
    public boolean cancelledOrFinalized(String hash) {
        Boolean cancelledOrFinalizedStatus = cancelledOrFinalized.get(hash);
        return cancelledOrFinalizedStatus != null && cancelledOrFinalizedStatus;
    }

    /**
     * @param hash order hash
     * @dev Query order approved order status
     */
    @View
    public boolean approvedOrders(String hash) {
        Boolean approved = approvedOrders.get(hash);
        return approved != null && approved;
    }

    /**
     * @return Return protocolFeeRecipient
     */
    @View
    public Address getProtocolFeeRecipient() {
        return protocolFeeRecipient;
    }




    /**
     * @param target   nft target
     * @param calldata nft transfer calldata
     * @dev transfer nft according calldata.
     */
    private boolean transferNFT(Address target, Calldata calldata) {
        if (!target.isContract()) {
            return false;
        }
        String[][] args = new String[][]{new String[]{target.toString()}, new String[]{calldata.getFrom().toString()},
                new String[]{calldata.getTo().toString()}, new String[]{calldata.getTokenId().toString()}, new String[]{calldata.getData()}};
        proxy.call("transferNFT721", null, args, BigInteger.ZERO);
        return true;
    }



    /**
     * @param order                     Order to approve
     * @param orderbookInclusionDesired Whether orderbook providers should include the order in their orderbooks
     * @dev Approve an order and optionally mark it for orderbook inclusion. Must be called by the maker of the order
     */
    protected void approveOrder(Order order, boolean orderbookInclusionDesired) {
        /* CHECKS */

        /* Assert sender is authorized to approve order. */
       // require(Msg.sender().equals(order.getMaker()), ERROR_SENDER_IS_NOT_MAKER);

        /* Calculate order hash. */
        String hash = hashToSign(order);

        /* Assert order has not already been approved. */
        Boolean approved = approvedOrders.get(hash);
       // require(approved == null || !approved, ERROR_ORDER_HAS_APPROVED);

        /* EFFECTS */

        /* Mark order as approved. */
        approvedOrders.put(hash, true);

        /* Log approval event. */
       // emit(new OrderApproved(hash, order.getExchange(), order.getMaker(), order.getTaker(), order.getMakerRelayerFee(), order.getTakerRelayerFee(), order.getMakerProtocolFee(), order.getTakerProtocolFee(), order.getFeeRecipient(), order.getSide(), order.getTarget(), order.getCalldata(), order.getPaymentToken(), order.getBasePrice(), order.getListingTime(), order.getExpirationTime(), order.getSalt(), orderbookInclusionDesired));
    }

    /**
     * @param order Order to cancel
     * @param sig   ECDSA signature
     * @dev Cancel an order, preventing it from being matched. Must be called by the maker of the order
     */
    protected void cancelOrder(Order order, String sig) {
        /* CHECKS */

        /* Calculate order hash. */
        String hash = requireValidOrder(order, sig);

        /* Assert sender is authorized to cancel order. */
        //require(Msg.sender().equals(order.getMaker()), ERROR_SENDER_IS_NOT_MAKER);

        /* EFFECTS */

        /* Mark order as cancelled, preventing it from being matched. */
        cancelledOrFinalized.put(hash, true);

        /* Log cancel event. */
        //emit(new OrderCancelled(hash));
    }

    /**
     * @param token
     * @param from
     * @param to
     * @param amount
     * @dev Transfer NRC20 Token by proxy. Revert when transferFrom return false
     */
    private void transferTokens(Address token, Address from, Address to, BigInteger amount) {
        if (ZERO.compareTo(amount) < 0) {
            String[][] args = new String[][]{new String[]{token.toString()}, new String[]{from.toString()}, new String[]{to.toString()}, new String[]{amount.toString()}};
            String returnValue = proxy.callWithReturnValue("transferERC20", null, args, BigInteger.ZERO);
            //require(Boolean.valueOf(returnValue), ERROR_RETURN_VALUE_IS_NOT_TRUE);
        }
    }

    /**
     * @param buy
     * @param sell
     * @return
     */
    private BigInteger calculateMatchPrice(Order buy, Order sell) {
      //  require(buy.getBasePrice().compareTo(sell.getBasePrice()) >= 0, ERROR_SELL_PRICE_NO_MATCH_BUY_PRICE);
        return !ZERO_ADDR.equals(sell.getFeeRecipient()) ? sell.getBasePrice() : buy.getBasePrice();
    }

    /**
     * @param buy
     * @param sell
     * @return
     */
    private Calldata replaceCalldata(Calldata buy, Calldata sell) {
        Calldata calldata = new Calldata();
        /* Revert if param of buyer or seller is illegal. */
        if (!(sell.getData() == null || sell.getData().trim().isEmpty())) {
           // require(sell.getData().equals(buy.getData()), ERROR_SELL_DATA_NO_MATCH_BUY_DATA);
            calldata.setData(sell.getData());
        }

        /* Require calldata can match its position. */
        //require(calldataCanMatch(buy, sell), ERROR_ORDER_CALL_DATA_CAN_MATCH);

        if (!ZERO_ADDR.equals(buy.getFrom())) {
            calldata.setFrom(buy.getFrom());
        } else {
            calldata.setFrom(sell.getFrom());
        }

        if (!ZERO_ADDR.equals(buy.getTo())) {
            calldata.setTo(buy.getTo());
        } else {
            calldata.setTo(sell.getTo());
        }

        calldata.setTokenId(buy.getTokenId());

        return calldata;
    }

    /**
     * @param buy
     * @param sell
     * @return
     */
    protected boolean calldataCanMatch(Calldata buy, Calldata sell) {
        if (!((!ZERO_ADDR.equals(buy.getFrom()) && ZERO_ADDR.equals(buy.getTo()) && ZERO_ADDR.equals(sell.getFrom()) && !ZERO_ADDR.equals(sell.getTo()))
                || (ZERO_ADDR.equals(buy.getFrom()) && !ZERO_ADDR.equals(buy.getTo()) && !ZERO_ADDR.equals(sell.getFrom()) && ZERO_ADDR.equals(sell.getTo())))) {
            return false;

        }

        if (buy.getTokenId().compareTo(sell.getTokenId()) != 0) {//token_id 要相同
            return false;
        }

        return buy.getData().equals(sell.getData());
    }

    /**
     * @param order Order to validate
     * @param sig   ECDSA signature
     * @dev Assert an order is valid and return its hash
     */
    private String requireValidOrder(Order order, String sig) {
        String hash = hashToSign(order);
        //require(validateOrder(hash, order, sig), ERROR_VALIDATE_ORDER);
        return hash;
    }

    /**
     * @param hash  Order hash (already calculated, passed to avoid recalculation)
     * @param order Order to validate
     * @param sig   ECDSA signature
     * @dev Validate a provided previously approved / signed order, hash, and signature.
     */
    protected boolean validateOrder(String hash, Order order, String sig) {
        if (!validateOrderParameters(order)) {
            return false;
        }

        Boolean cancelledOrFinalizedStatus = cancelledOrFinalized.get(hash);

        if (cancelledOrFinalizedStatus != null && cancelledOrFinalizedStatus) {
            return false;
        }

        Boolean approved = approvedOrders.get(hash);
        if (approved != null && approved) {// approve列表需要自己是maker 才能放进去
            return true;
        }

        String pubKey = getPubKey(order.getMaker());
        if ("".equals(pubKey)) {
            return false;
        }

        return Utils.verifySignatureData(hash, sig, pubKey);//走这里的话 说明订单没在approve列表里 是线下进行订单签名的
    }

    /**
     * @param owner
     * @return
     */
    private String getPubKey(Address owner) {
        String[][] args = new String[][]{new String[]{owner.toString()},};
        return proxy.callWithReturnValue("getPubKey", null, args, BigInteger.ZERO);
    }

    /**
     * @param buy  Buy-side order
     * @param sell Sell-side order
     * @return Whether or not the two orders can be matched
     * @dev Return whether or not two orders can be matched with each other by basic parameters (does not check order signatures / calldata or perform static calls)
     */
    public boolean ordersCanMatch(Order buy, Order sell) {
        return (
                /* Must be opposite-side. */
                (buy.getSide() == Side.BUY && sell.getSide() == Side.SELL) &&
                        /* Must use same payment token. */
                        (buy.getPaymentToken() != null && sell.getPaymentToken() != null && buy.getPaymentToken().equals(sell.getPaymentToken())) &&
                        /* Must match maker/taker addresses. */
                        (sell.getTaker() != null && buy.getTaker() != null) && (ZERO_ADDR.equals(sell.getTaker()) || sell.getTaker().equals(buy.getMaker())) && (ZERO_ADDR.equals(buy.getTaker()) || buy.getTaker().equals(sell.getMaker())) &&
                        /* One must be maker and the other must be taker. */
                        (sell.getFeeRecipient() != null && buy.getFeeRecipient() != null) && ((ZERO_ADDR.equals(sell.getFeeRecipient()) && !ZERO_ADDR.equals(buy.getFeeRecipient())) || (!ZERO_ADDR.equals(sell.getFeeRecipient()) && ZERO_ADDR.equals(buy.getFeeRecipient()))) && (buy.getTarget() != null && !ZERO_ADDR.equals(buy.getTarget()) && buy.getTarget().equals(sell.getTarget())) &&
                        /* Buy-side order must be settleable. */
                        (canSettleOrder(buy.getListingTime(), buy.getExpirationTime())) &&
                        /* Sell-side order must be settleable. */
                        (canSettleOrder(sell.getListingTime(), sell.getExpirationTime()))
        );
    }

    /**
     * @param listingTime    Order listing time
     * @param expirationTime Order expiration time
     * @dev Return whether or not an order can be settled
     * @dev Precondition: parameters have passed validateParameters
     */
    private boolean canSettleOrder(int listingTime, int expirationTime) {
        long now = System.currentTimeMillis();;
        return (listingTime < now) && (expirationTime == 0 || now < expirationTime);
    }

    /**
     * @param order Order to validate
     * @dev Validate order parameters (does *not* check signature validity)
     */
    protected boolean validateOrderParameters(Order order) {

        /* Order must be fixed price order, so must always true*/

        /* Order must have sufficient protocol fees. */ //订单中合约费率 满足合约最小费率
        return order.getMakerProtocolFee().compareTo(minimumMakerProtocolFee) >= 0 && order.getTakerProtocolFee().compareTo(minimumTakerProtocolFee) >= 0;
    }

    /**
     * @param order Order to hash
     * @return Hash of message prefix and order hash per Ethereum format
     * @dev Hash an order, returning the hash that a client must sign, including the standard message prefix
     */
    protected String hashToSign(Order order) {
        return Utils.sha3(stringToHexString(signedMessage) + hashOrder(order));
    }

    /**
     * @param order Order to hash
     * @return Hash of order
     * @dev Hash an order, returning the canonical order hash, without the message prefix
     */
    protected String hashOrder(Order order) {
        return Utils.sha3(stringToHexString(order.toString()));
    }


    private static String stringToHexString(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            String c = Integer.toHexString(ch);
            str = str + c;
        }
        return str;
    }

}
