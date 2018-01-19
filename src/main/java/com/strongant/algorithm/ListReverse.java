package com.strongant.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 集合反转
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class ListReverse {

    public static void main(String[] args) {

        int[] arr = new int[]{
                10, 9, 8, 7, 6, 5, 4, 3, 2, 1
        };

        List list = new ArrayList();

        list.add(3);
        list.add(2);
        list.add(1);

        //其中jdk中自带的reverse方法内部实现使用了右移操作相关判断，比较注意的是List的set方法
        //该方法结构如下： E set(int index, E element) 在指定的集合索引插入某元素，然后返回该索引原始值
        //参考AbstractSequentialList.java 中的 set(int index, E element) 方法可知
        Collections.reverse(list);

        System.out.println(list);


        reverseArray(arr);

        for (int i : arr) {
            System.out.print(i);
            System.out.print("\t");
        }
    }

    private static void reverseArray(int[] array) {
        final int len = array.length - 1;
        //右移1相当于除以2，效率更高
        final int mid = array.length >> 1;
        for (int i = 0; i < mid; i++) {
            final int temp = array[len - i];
            array[len - i] = array[i];
            array[i] = temp;
        }
    }


}
