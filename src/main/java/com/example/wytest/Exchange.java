package com.example.wytest;

//import io.ivymarket.interfaces.IExchange;

import com.example.wytest.Address;
import io.nuls.contract.sdk.annotation.Required;
import io.nuls.contract.sdk.annotation.View;

import java.math.BigInteger;

//import static io.ivymarket.errors.Errors.*;

/**
 * @author Project IVY Developers
 * @title Exchange
 */
public class Exchange extends ExchangeCore  {

    private static final String name = "Project IVY Exchange";

    private static final String version = "1.0";

    private static final String codename = "Lambton Worm";

    public Exchange(Address proxyContract, Address protocolFeeAddress) {
        super(proxyContract, protocolFeeAddress);
    }

    @View
    public String name() {
        return name;
    }

    @View
    public String version() {
        return version;
    }

    @View
    public String codename() {
        return codename;
    }




    /**
     * @dev Call ordersCanMatch
     */
    @View
    public boolean ordersCanMatch_(@Required String[] args) {

        //require(args != null && args.length == 38, ERROR_ORDER_CALL_DATA_CAN_MATCH);

        Order buy = new Order(new Address(args[0]), new Address(args[1]), new Address(args[2]), new BigInteger(args[3]), new BigInteger(args[4]), new BigInteger(args[5]), new BigInteger(args[6]), new Address(args[7]), new BigInteger(args[8]).intValue(), new Address(args[9]), new Calldata(new Address(args[10]), new Address(args[11]), new BigInteger(args[12]), args[13]), new Address(args[14]), new BigInteger(args[15]), new BigInteger(args[16]).intValue(), new BigInteger(args[17]).intValue(), new BigInteger(args[18]));

        Order sell = new Order(new Address(args[19]), new Address(args[20]), new Address(args[21]), new BigInteger(args[22]), new BigInteger(args[23]), new BigInteger(args[24]), new BigInteger(args[25]), new Address(args[26]), new BigInteger(args[27]).intValue(), new Address(args[28]), new Calldata(new Address(args[29]), new Address(args[30]), new BigInteger(args[31]), args[32]), new Address(args[33]), new BigInteger(args[34]), new BigInteger(args[35]).intValue(), new BigInteger(args[36]).intValue(), new BigInteger(args[37]));

        return ordersCanMatch(buy, sell);
    }


    /**
     * @return Whether the orders' calldata can be matched
     * @dev Return whether or not two orders' calldata specifications can match
     */

    public boolean orderCalldataCanMatch(String[] from, String[] to, String[] tokenId, String[] data) {

        //require(from != null && from.length == 2 && to != null && to.length == 2 && tokenId != null && tokenId.length == 2 && data != null && data.length == 2, ERROR_ORDER_CALL_DATA_CAN_MATCH);

        Calldata buy = new Calldata(new Address(from[0]), new Address(to[0]), new BigInteger(tokenId[0]), data[0]);
        Calldata sell = new Calldata(new Address(from[1]), new Address(to[1]), new BigInteger(tokenId[1]), data[1]);
        return calldataCanMatch(buy, sell);
    }




}