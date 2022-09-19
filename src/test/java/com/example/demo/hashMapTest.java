package com.example.demo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class hashMapTest {

    private Map<String, Boolean> cancelledOrFinalized = new HashMap<String, Boolean>();
    @Test
    public void test1() {
        cancelledOrFinalized.put("a",true);
        String hash="a";

        Boolean cancelledOrFinalizedStatus = cancelledOrFinalized.get(hash);//map key 不存在 返回null
        boolean b = null == cancelledOrFinalizedStatus;
        System.out.println(b);
        if (cancelledOrFinalizedStatus != null && cancelledOrFinalizedStatus) {
            System.out.println("false");
        }

    }
}
