package com.example.wytest;

import com.example.wytest.Address;

import java.math.BigInteger;

public class Order {

    /* Exchange address, intended as a versioning mechanism. */
    private Address exchange;//0交易合约地址 用于版本控制
    /* Order maker address. */
    private Address maker;//1  制作订单的人或者合约
    /* Order taker address, if specified. */ //意思可以为0
    private Address taker;//2  接受订单的人或者合约
    /* Maker relayer fee of the order, unused for taker order. */
    private BigInteger makerRelayerFee;//3 中间费 给交易所的钱 这是费率 还会除以10000
    /* Taker relayer fee of the order, or maximum taker fee for a taker order. */
    private BigInteger takerRelayerFee;//4 中间费 给交易所的钱 这是费率 还会除以10000
    /* Maker protocol fee of the order, unused for taker order. */
    private BigInteger makerProtocolFee;//5 协议费 给合约的钱
    /* Taker protocol fee of the order, or maximum taker fee for a taker order. */
    private BigInteger takerProtocolFee;//6 协议费 给合约的钱
    /* Order fee recipient or zero address for taker order. */
    private Address feeRecipient;//7 交易所的收款地址
    /* Side (buy/sell, 0,1). */
    private int side;//8
    /* Target. */
    private Address target;//9  721合约地址
    /* Calldata. */
    private Calldata calldata;//10 11 12 13
    /* Token used to pay for the order, or the zero-address as a sentinel value for Ether. */
    private Address paymentToken;//14 付款的代币的地址 如果是0地址就转nuls币
    /* Base price of the order (in paymentTokens). */
    private BigInteger basePrice;//15
    /* Listing timestamp. */
    private int listingTime;//16  挂单时间
    /* Expiration timestamp - 0 for no expiry. */
    private int expirationTime;//17 单过期时间
    /* Order salt, used to prevent duplicate hashes. */
    private BigInteger salt;//18

    public Order(Address exchange, Address maker, Address taker, BigInteger makerRelayerFee, BigInteger takerRelayerFee,
                 BigInteger makerProtocolFee, BigInteger takerProtocolFee, Address feeRecipient, int side, Address target,
                 Calldata calldata, Address paymentToken, BigInteger basePrice, int listingTime, int expirationTime, BigInteger salt) {
        this.exchange = exchange;
        this.maker = maker;
        this.taker = taker;
        this.makerRelayerFee = makerRelayerFee;
        this.takerRelayerFee = takerRelayerFee;
        this.makerProtocolFee = makerProtocolFee;
        this.takerProtocolFee = takerProtocolFee;
        this.feeRecipient = feeRecipient;
        this.side = side;
        this.target = target;
        this.calldata = calldata;
        this.paymentToken = paymentToken;
        this.basePrice = basePrice;
        this.listingTime = listingTime;
        this.expirationTime = expirationTime;
        this.salt = salt;
    }

    public Address getExchange() {
        return exchange;
    }

    public void setExchange(Address exchange) {
        this.exchange = exchange;
    }

    public Address getMaker() {
        return maker;
    }

    public void setMaker(Address maker) {
        this.maker = maker;
    }

    public Address getTaker() {
        return taker;
    }

    public void setTaker(Address taker) {
        this.taker = taker;
    }

    public BigInteger getMakerRelayerFee() {
        return makerRelayerFee;
    }

    public void setMakerRelayerFee(BigInteger makerRelayerFee) {
        this.makerRelayerFee = makerRelayerFee;
    }

    public BigInteger getTakerRelayerFee() {
        return takerRelayerFee;
    }

    public void setTakerRelayerFee(BigInteger takerRelayerFee) {
        this.takerRelayerFee = takerRelayerFee;
    }

    public BigInteger getMakerProtocolFee() {
        return makerProtocolFee;
    }

    public void setMakerProtocolFee(BigInteger makerProtocolFee) {
        this.makerProtocolFee = makerProtocolFee;
    }

    public BigInteger getTakerProtocolFee() {
        return takerProtocolFee;
    }

    public void setTakerProtocolFee(BigInteger takerProtocolFee) {
        this.takerProtocolFee = takerProtocolFee;
    }

    public Address getFeeRecipient() {
        return feeRecipient;
    }

    public void setFeeRecipient(Address feeRecipient) {
        this.feeRecipient = feeRecipient;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public Address getTarget() {
        return target;
    }

    public void setTarget(Address target) {
        this.target = target;
    }

    public Calldata getCalldata() {
        return calldata;
    }

    public void setCalldata(Calldata calldata) {
        this.calldata = calldata;
    }

    public Address getPaymentToken() {
        return paymentToken;
    }

    public void setPaymentToken(Address paymentToken) {
        this.paymentToken = paymentToken;
    }

    public BigInteger getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigInteger basePrice) {
        this.basePrice = basePrice;
    }

    public int getListingTime() {
        return listingTime;
    }

    public void setListingTime(int listingTime) {
        this.listingTime = listingTime;
    }

    public int getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(int expirationTime) {
        this.expirationTime = expirationTime;
    }

    public BigInteger getSalt() {
        return salt;
    }

    public void setSalt(BigInteger salt) {
        this.salt = salt;
    }


    @Override
    public String toString() {
        return "{" +
                "\"exchange\":\"" + exchange.toString() + "\"" +
                ",\"maker\":\"" + maker.toString() + "\"" +
                ",\"taker\":\"" + taker.toString() + "\"" +
                ",\"makerRelayerFee\":" + makerRelayerFee.toString() +
                ",\"takerRelayerFee\":" + takerRelayerFee.toString() +
                ",\"makerProtocolFee\":" + makerProtocolFee.toString() +
                ",\"takerProtocolFee\":" + takerProtocolFee.toString() +
                ",\"feeRecipient\":\"" + feeRecipient.toString() + "\"" +
                ",\"side\":" + side +
                ",\"target\":\"" + target.toString() + "\"" +
                ",\"calldata\":{" +
                "\"from\":\"" + calldata.getFrom().toString() + "\"" +
                ",\"to\":\"" + calldata.getTo().toString() + "\"" +
                ",\"tokenId\":" + calldata.getTokenId().toString() +
                ",\"data\":\"" + calldata.getData() + "\"" +
                "}" +
                ",\"paymentToken\":\"" + paymentToken.toString() + "\"" +
                ",\"basePrice\":" + basePrice.toString() +
                ",\"listingTime\":" + listingTime +
                ",\"expirationTime\":" + expirationTime +
                ",\"salt\":" + salt +
                "}";
    }

    public String toString2(){
        return "[" +
                "\""+ exchange.toString() + "\"" +
                ",\"" + maker.toString() + "\"" +
                ",\"" + taker.toString() + "\"" +
                ",\"" + makerRelayerFee.toString() +"\"" +
                ",\"" + takerRelayerFee.toString() +"\"" +
                ",\"" + makerProtocolFee.toString() +"\"" +
                ",\"" + takerProtocolFee.toString() +"\"" +
                ",\"" + feeRecipient.toString() + "\"" +
                ",\"" + side +"\"" +
                ",\"" + target.toString() + "\"" +
                ",\"" + calldata.getFrom().toString() + "\"" +
                ",\"" + calldata.getTo().toString() + "\"" +
                ",\"" + calldata.getTokenId().toString() +"\"" +
                ",\"" + calldata.getData() + "\"" +
                ",\"" + paymentToken.toString() + "\"" +
                ",\"" + basePrice.toString() +"\"" +
                ",\"" + listingTime +"\"" +
                ",\"" + expirationTime +"\"" +
                ",\"" + salt +"\"" +
                "]";

    }
}
