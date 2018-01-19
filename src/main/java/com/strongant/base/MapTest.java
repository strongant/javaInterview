package com.strongant.base;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class MapTest {

    public static void main(String[] args) {


        Map<String,Integer> map = new LinkedHashMap<>();

        map.put("111", 1);

        System.out.println(map.containsKey(null));
    }
}
