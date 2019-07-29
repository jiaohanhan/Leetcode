package sword2offer;

/**
 * 连续子数组的最大和
 * 输入一个整型数组，里面有正数也有负数，数组中一个或者连续的多个整数组成一个子数组。
 * 求所有子数组中的最大值，要求O(n)
 *
 * 动态规划
 */
public class NO_31 {
    public int findGreatestSumOfSubArray(int[] arr){
        if (arr.length == 0) return 0;
        int res = arr[0];
        int sum = arr[0];
        for (int anArr : arr) {
            sum = sum < 0 ? anArr : sum + anArr;
            res = sum > res ? sum : res;
        }
        return res;
    }
}
