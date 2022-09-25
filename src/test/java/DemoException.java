import io.nuls.base.signture.SignatureUtil;
import io.nuls.core.crypto.ECKey;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @Author:LiuKangwei
 * @Date:2019/9/11 23:06
 * @Description:
 */
@Slf4j
public class DemoException {
    public static void main(String[] args) {
        try {
            throw new Exception("hello exception");
        } catch (Exception e) {
            System.out.println("catch exception");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            System.out.println("--------");
            e.printStackTrace();//报错没有打进日志中，没有时间，所以这种方式不好。一般会用异常封装类来封装异常到日志中。
        }
    }


    @Test
    public void de() {
        String i = "abcd";

        byte[] bytes = i.getBytes();//字符转字节
//[97, 98, 99, 100]
        System.out.println(Arrays.toString(bytes));

    }


    @Test
    public void de2() throws UnsupportedEncodingException {
        byte[] bytes = {97, 98, 99, 100};

        String s = new String(bytes, "utf-8");//字节转字符

        System.out.println(s);

    }

    @Test
    public void ok() {//todo 待研究

        char a = 'a';
        ByteBuffer heapByteBuffer = ByteBuffer.allocate(16);
        ByteBuffer byteBuffer = heapByteBuffer.putChar(a);
        byte b = byteBuffer.get(0);
        for(int i=0;i<16;i++){
            char aChar = byteBuffer.getChar(i);
            System.out.println(aChar);

        }


        System.out.println(byteBuffer);
        System.out.println(b);



    }
    @Test
    public  void test72() throws IOException {
        String abc = stringToHexString("Angelillou");
        System.out.println(abc);

        byte[] data = {65, 110, 103, 101, 108, 105, 108, 108, 111, 117};// 原始数据
        String privateKeyHex= "93d062c9790a289f928e21c9f3ac7b7ce6fe045d6aaf242d502cdcda6d9e0c84";
        byte[] bytes = hexTobytes(privateKeyHex);
        byte[] privateKey = bytes;// 私钥
        ECKey ecKey = ECKey.fromPrivate(new BigInteger(1, privateKey));
        byte[] signBytes = SignatureUtil.signDigest(data, ecKey).getSignBytes();// 签名数据
        String bytesToHex = bytesToHex(signBytes);
        System.out.println(bytesToHex);// string 类型的签名数据 3044022100BBF57788C259EA317FA28E9035ACEF23273256D3E1F65CB48BA978308EFA5A5E021F723579724E2B6FB6CD2C3D85508A5A00B52EA9F5B3BD3C1176C9EFCACC1CD1
        //公钥为0232bdaf6573319eba3b433ed88d6d4b0d06ea3ad9a504596fe967a2dbf95fc07c

    }
    @Test
    public  void test90() {
        String abc = stringToHexString("abc");
        System.out.println(abc);
        byte[] bytes = hexTobytes(abc);
        System.out.println(Arrays.toString(bytes));


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

    public static byte[] hexTobytes(String hex) {
        if (hex.length() < 1) {
            return null;
        } else {
            byte[] result = new byte[hex.length() / 2];
            int j = 0;
            for(int i = 0; i < hex.length(); i+=2) {
                result[j++] = (byte)Integer.parseInt(hex.substring(i,i+2), 16);
            }
            return result;
        }
    }

    public static String bytesToHex(byte[] b) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if(hex.length() < 2) {
                hex = "0" + hex;
            }
            sb.append(hex.toUpperCase());
        }

        return sb.toString();
    }


}
