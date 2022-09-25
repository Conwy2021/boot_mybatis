
import com.example.wytest.*;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import jdk.nashorn.internal.ir.IdentNode;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;


public class wyTest {

/*
* buy-from 	buy-to	sell-from	sell-to
*    1	       0	    0 	       1
*    0	       1	    1	       0

 * */
/*测试网零地址 tNULSeBaMhZnRteniCy3UZqPjTbnWKBPHX1a5d
* */
    @Test
    public void Calldata_test5(){

        String[] from={"tNULSeBaMtnwRt525LzXp49DEQA1wo5wFSQaAk","tNULSeBaMhZnRteniCy3UZqPjTbnWKBPHX1a5d"};
        String[] to={"tNULSeBaMhZnRteniCy3UZqPjTbnWKBPHX1a5d","tNULSeBaMk6m2JQc7wrvJ6A7meeduvgFpKsCah"};
        String[] tokenId={"14807467746922729387712905830938112223655954521150241913038014815321431002589017249083900267","14807467746922729387712905830938112223655954521150241913038014815321431002589017249083900267"};
        String[] data={"",""};
        Exchange exchange = new Exchange(new Address(""), new Address(""));
        boolean b = exchange.orderCalldataCanMatch(from, to, tokenId, data);
        System.out.println("calldata match is "+b);
    }

    @Test
    public  void  test32(){
        // __________________________ buyorder____________________________________
        Address exchange
                =new Address("tNULSeBaN3ZDCnaQytnBeinB42KVPx9dArJyTb");
        Address maker
                =new Address("tNULSeBaMsvfuGcosTR5dedtk8ksdfarrQWz3X");
        Address taker
                =new Address("tNULSeBaMk6m2JQc7wrvJ6A7meeduvgFpKsCah");
        BigInteger makerRelayerFee
                =new BigInteger("0");
        BigInteger takerRelayerFee
                =new BigInteger("0");
        BigInteger makerProtocolFee
                =new BigInteger("0");;
        BigInteger takerProtocolFee
                =new BigInteger("0");;
        Address feeRecipient
                =new Address("tNULSeBaMtnwRt525LzXp49DEQA1wo5wFSQaAk");
        int side
                =new BigInteger("0").intValue();
        Address target
                =new Address("tNULSeBaN9XzbbHmjBYA82EJBg2CqPWNBHHW9V");
        Calldata calldata
                =new Calldata(new Address("tNULSeBaMtnwRt525LzXp49DEQA1wo5wFSQaAk"),new Address("tNULSeBaMhZnRteniCy3UZqPjTbnWKBPHX1a5d"),new BigInteger("14807467746922729387712905830938112223655954521150241913038014815321431002589017249083900267"),"123");
        Address paymentToken
                =new Address("tNULSeBaN2SpC8sCLX8Xg7RKcWiDUvaDfSYWCJ");
        BigInteger basePrice
                =new BigInteger("333333");
        int listingTime
                = new BigInteger("1663863847").intValue();
        int expirationTime
                =new BigInteger("0").intValue();
        BigInteger salt
                =new BigInteger("123");
        Order buy = new Order(exchange,maker,taker,makerRelayerFee,takerRelayerFee,makerProtocolFee,takerProtocolFee,feeRecipient,side,target,calldata,paymentToken,basePrice,listingTime,expirationTime,salt);

        // __________________________ sell order2____________________________________
        Address exchange2
                =new Address("tNULSeBaN3ZDCnaQytnBeinB42KVPx9dArJyTb");
        Address maker2
                =new Address("tNULSeBaMk6m2JQc7wrvJ6A7meeduvgFpKsCah");
        Address taker2
                =new Address("tNULSeBaMhZnRteniCy3UZqPjTbnWKBPHX1a5d");
        BigInteger makerRelayerFee2
                =new BigInteger("0");
        BigInteger takerRelayerFee2
                =new BigInteger("0");
        BigInteger makerProtocolFee2
                =new BigInteger("0");;
        BigInteger takerProtocolFee2
                =new BigInteger("0");;
        Address feeRecipient2
                =new Address("tNULSeBaMhZnRteniCy3UZqPjTbnWKBPHX1a5d");//0地址
        int side2
                =new BigInteger("1").intValue();//卖单标识
        Address target2
                =new Address("tNULSeBaN9XzbbHmjBYA82EJBg2CqPWNBHHW9V");;
        Calldata calldata2
                =new Calldata(new Address("tNULSeBaMhZnRteniCy3UZqPjTbnWKBPHX1a5d"),new Address("tNULSeBaMk6m2JQc7wrvJ6A7meeduvgFpKsCah"),new BigInteger("14807467746922729387712905830938112223655954521150241913038014815321431002589017249083900267"),"123");
        Address paymentToken2
                =new Address("tNULSeBaN2SpC8sCLX8Xg7RKcWiDUvaDfSYWCJ");
        BigInteger basePrice2
                =new BigInteger("222222");
        int listingTime2
                = new BigInteger("1663863847").intValue();
        System.out.println(listingTime2);//1591337314  1663863847
        int expirationTime2
                =new BigInteger("0").intValue();
        BigInteger salt2
                =new BigInteger("123");
        Order sell = new Order(exchange2,maker2,taker2,makerRelayerFee2,takerRelayerFee2,makerProtocolFee2,takerProtocolFee2,feeRecipient2,side2,target2,calldata2,paymentToken2,basePrice2,listingTime2,expirationTime2,salt2);
        System.out.println("-----------------------");

        /*if (stringToHexString(buy2.toString()).equals(stringToHexString(buy.toString()))){
            System.out.println("true");
        }else {
            System.out.println("false");
        }*/

        ExchangeCore exchangeCore = new ExchangeCore(new Address(""), new Address(""));
        boolean b = exchangeCore.ordersCanMatch(buy, sell);
        System.out.println(b);
        String buy_before = buy.toString2().substring(0, buy.toString2().length() - 1);
        String sell_last = sell.toString2().substring(0, buy.toString2().length() - 1);
        sell_last=sell_last.substring(1);
        sell_last=sell_last+","+"\""+"\""+","+"\""+"\""+","+"\""+"\""+"]";
        //System.out.println(sell_last);
        System.out.println(buy_before+","+sell_last);

    }
    @Test
    public void  make_tokenID(){
        Address address = new Address("tNULSeBaMtnwRt525LzXp49DEQA1wo5wFSQaAk");
        checkTokenId2(address,  new BigInteger("1480746774692272938771802558764075179635102718694284302815304704940259894277886874988401162221"));
    }
    private void checkTokenId2(Address from, BigInteger tokenId) {
        String id = tokenId.toString();
        System.out.println("tokenId -->"+id);
        String fromString = from.toString();
        System.out.println("fromString-->"+fromString);
        BigInteger fromBigint = new BigInteger(from.toString().getBytes());
        System.out.println("fromBigint-->"+fromBigint);
        String fromBigint_toString = fromBigint.toString();
        System.out.println("fromBigint_toString-->"+fromBigint_toString);
        boolean b = id.startsWith(fromBigint.toString());
        System.out.println("startsWith-->"+b);
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

    @Test
    public  void  test116(){
        String[] args={"tNULSeBaN3ZDCnaQytnBeinB42KVPx9dArJyTb","tNULSeBaMsvfuGcosTR5dedtk8ksdfarrQWz3X","tNULSeBaMk6m2JQc7wrvJ6A7meeduvgFpKsCah","10101","0","0","0","tNULSeBaMkCMq9Fp3FQJGrcErcK4T5szD3JV8E","0","tNULSeBaN9XzbbHmjBYA82EJBg2CqPWNBHHW9V","tNULSeBaMkCMq9Fp3FQJGrcErcK4T5szD3JV8E","tNULSeBaMhZnRteniCy3UZqPjTbnWKBPHX1a5d","14807467746922729387712658645761213421212201993433395339925525428915862277453841196828211269123","123","tNULSeBaN2SpC8sCLX8Xg7RKcWiDUvaDfSYWCJ","12000000001","1663743680866","0","123"};
        Order buy = new Order(new com.example.wytest.Address(args[0]), new com.example.wytest.Address(args[1]), new com.example.wytest.Address(args[2]), new BigInteger(args[3]), new BigInteger(args[4]), new BigInteger(args[5]), new BigInteger(args[6]), new com.example.wytest.Address(args[7]), new BigInteger(args[8]).intValue(), new com.example.wytest.Address(args[9]), new Calldata(new com.example.wytest.Address(args[10]), new com.example.wytest.Address(args[11]), new BigInteger(args[12]), args[13]), new com.example.wytest.Address(args[14]), new BigInteger(args[15]), new BigInteger(args[16]).intValue(), new BigInteger(args[17]).intValue(), new BigInteger(args[18]));

        System.out.println(stringToHexString(buy.toString()));
        String[] args2={"tNULSeBaN3ZDCnaQytnBeinB42KVPx9dArJyTb","tNULSeBaMsvfuGcosTR5dedtk8ksdfarrQWz3X","tNULSeBaMk6m2JQc7wrvJ6A7meeduvgFpKsCah","10101","0","0","0","tNULSeBaMkCMq9Fp3FQJGrcErcK4T5szD3JV8E","0","tNULSeBaN9XzbbHmjBYA82EJBg2CqPWNBHHW9V","tNULSeBaMkCMq9Fp3FQJGrcErcK4T5szD3JV8E","tNULSeBaMhZnRteniCy3UZqPjTbnWKBPHX1a5d","14807467746922729387712658645761213421212201993433395339925525428915862277453841196828211269123","123","tNULSeBaN2SpC8sCLX8Xg7RKcWiDUvaDfSYWCJ","1200000000","11663743680866","0","123"};
        Order buy2 = new Order(new com.example.wytest.Address(args2[0]), new com.example.wytest.Address(args2[1]), new com.example.wytest.Address(args2[2]), new BigInteger(args2[3]), new BigInteger(args2[4]), new BigInteger(args2[5]), new BigInteger(args2[6]), new com.example.wytest.Address(args2[7]), new BigInteger(args2[8]).intValue(), new com.example.wytest.Address(args2[9]), new Calldata(new com.example.wytest.Address(args2[10]), new com.example.wytest.Address(args2[11]), new BigInteger(args2[12]), args2[13]), new com.example.wytest.Address(args2[14]), new BigInteger(args2[15]), new BigInteger(args2[16]).intValue(), new BigInteger(args2[17]).intValue(), new BigInteger(args2[18]));
        System.out.println("-----------------------");
        System.out.println(stringToHexString(buy2.toString()));
        System.out.println("-----------------------");
        if (stringToHexString(buy2.toString()).equals(stringToHexString(buy.toString()))){
            System.out.println("true");
        }else {
            System.out.println("false");
        }

    }

    @Test
    public void test163(){

        OneTest oneTest = new OneTest(new BigInteger("1").intValue(), new Address("41"),new Address("a"));
        OneTest oneTest2 = new OneTest(new BigInteger("1").intValue(), new Address("4"),new Address("1a"));
        boolean equals = oneTest.toString().equals(oneTest.toString1());
        System.out.println(equals);
        System.out.println(oneTest);
        System.out.println(oneTest.toString1());
         /*boolean equals1 = stringToHexString(oneTest.toString()).equals(stringToHexString(oneTest2.toString()));
        System.out.println(equals1);
        System.out.println(oneTest);
        System.out.println(oneTest2);*/

    }

    @Test
    public  void  test185(){
        Address exchange2
                =new Address("tNULSeBaN3ZDCnaQytnBeinB42KVPx9dArJyTb");
        Address maker2
                =new Address("tNULSeBaMk6m2JQc7wrvJ6A7meeduvgFpKsCah");
        Address taker2
                =new Address("tNULSeBaMsvfuGcosTR5dedtk8ksdfarrQWz3X");
        BigInteger makerRelayerFee2
                =new BigInteger("0");
        BigInteger takerRelayerFee2
                =new BigInteger("0");
        BigInteger makerProtocolFee2
                =new BigInteger("0");;
        BigInteger takerProtocolFee2
                =new BigInteger("0");;
        Address feeRecipient2
                =new Address("tNULSeBaMtnwRt525LzXp49DEQA1wo5wFSQaAk");
        int side2
                =new BigInteger("0").intValue();
        Address target2
                =new Address("tNULSeBaN9XzbbHmjBYA82EJBg2CqPWNBHHW9V");;
        Calldata calldata2
                =new Calldata(new Address("tNULSeBaMhZnRteniCy3UZqPjTbnWKBPHX1a5d"),new Address("tNULSeBaMk6m2JQc7wrvJ6A7meeduvgFpKsCah"),new BigInteger("14807467746922729387712905830938112223655954521150241913038014815321431002589017249083900267"),"123");
        Address paymentToken2
                =new Address("tNULSeBaN2SpC8sCLX8Xg7RKcWiDUvaDfSYWCJ");
        BigInteger basePrice2
                =new BigInteger("222222");
        int listingTime2
                = new BigInteger("1663743680866").intValue();
        int expirationTime2
                =new BigInteger("0").intValue();
        BigInteger salt2
                =new BigInteger("123");
        Order sell = new Order(exchange2,maker2,taker2,makerRelayerFee2,takerRelayerFee2,makerProtocolFee2,takerProtocolFee2,feeRecipient2,side2,target2,calldata2,paymentToken2,basePrice2,listingTime2,expirationTime2,salt2);

        System.out.println(sell.toString2());
    }
}
