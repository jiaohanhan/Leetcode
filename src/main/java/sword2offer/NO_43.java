package sword2offer;

import java.util.ArrayList;

/**
 * 和为S的两个数字
 * 题目描述：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，
 *  输出两个数的乘积最小的。
 */
public class NO_43 {
    public ArrayList<Integer> findNumbersWithSum(int[] arr, int sum) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (arr == null) return res;
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int curSum = arr[start] + arr[end];
            if (sum == curSum){
                res.add(arr[start]);
                res.add(arr[end]);
                break;
            } else if (curSum > sum) {
                end--;
            }else {
                start++;
            }
        }
        return res;
    }
}
