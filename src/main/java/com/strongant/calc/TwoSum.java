package com.strongant.calc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个数组，给定一个目标值，如果该数组中存在两个数相加等于目标值的索引
 * <p>
 * 比如：有一个数组 arr = [1,2,3,4,5,6]  目标值：11
 * 此时应该返回： 给出索引数组 [4,5]
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class TwoSum {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4};
        int target = 7;
        //int[] result = twosum(array, target);

        List<Integer> result = twosumByMap(array, target);

        System.out.println(result);
    }

    /**
     * 使用Map进行缓存，从而减少一次循环，将时间复杂度降低为On
     * @param array
     * @param target
     * @return
     */
    private static List<Integer> twosumByMap(int[] array, int target) {

        // 首先声明一个Map 用来缓存已经遍历的值
        Map<Integer,Integer> dict =  new HashMap<>(8);

        List<Integer> list = new ArrayList<>(2);

        final int len = array.length;

        for (int i = 0; i < len; i++) {

            if (dict.containsKey(target - array[i])) {
                list.add(i);
                list.add(dict.get(target - array[i]));
                return list;
            } else {
                dict.put(array[i],i);
            }
        }
        return list;
    }

    /**
     * 算法复杂度度为n^2,效率低下，不推荐
     * @param array
     * @param target
     * @return
     */
    private static int[] twosum(int[] array, int target) {

        int len = array.length;

        int[] result = new int[2];

        for (int i = 0; i < len; i++) {

            for (int j = 0; j < len; j++) {
                if (target - array[i] == array[j]) {
                    result[0] = j;
                    result[1] = i;
                    break;
                }
            }
        }

        return result;
    }


}
