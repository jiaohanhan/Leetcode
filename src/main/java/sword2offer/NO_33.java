package sword2offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 * 例如输入数组{3， 32 ，321}，则打印出这三个数字能排成的最小数字为321323
 *
 */
public class NO_33 {
    public String printMinNumber(int[] numbers){
        /**
         * 1. 用list装numbers数组中的数
         * 2.使用collection.sort排序，排序是将str1+""+str2 和str2+""+str1的大小进行比较
         * 3.将排序后的数组进行拼接
         */
        if (numbers == null || numbers.length == 0) return "";
        List<Integer> list = new ArrayList<Integer>();
        for (int i : numbers) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i);
        }
        return sb.toString();
    }
}
