package sword2offer;

/**
 * 题目描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
 *      求该青蛙跳上一个n级台阶总共有几种跳法。
 *
 * 解题思路：类似斐波那契数列，可以递归，也可以动态规划
 *
 */
public class NO_9_2 {
    public static void main(String[] args) {
        System.out.println(count1(10));
        System.out.println(count2(10));
        System.out.println(count3(10));
        System.out.println(count4(10));
    }

    // 递归
    public static int count1(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("非法参数");
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        return count1(n - 1) + count1(n - 2);

    }

    // 动态规划 空间换时间
    public static int count2(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("非法参数");
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    // 动态规划的优化,只保留最近三次的数据
    public static int count3(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("非法参数");
        int[] arr = new int[3];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            // 用arr[0]保存结果
            arr[0] = arr[1] + arr[2];
            arr[1] = arr[2];
            arr[2] = arr[0];

        }

        return arr[0];
    }

    // 再优化，二次交换数据都没必要
    public static int count4(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("非法参数");
        int[] arr = new int[3];
        int j = 0; // 返回值的位置
        for (int i = 1; i < n + 1; i++) {
            j = i % 3;
            if (i == 1) {
                arr[j] = 1;
            } else if (i == 2) {
                arr[j] = 2;
            } else {
                arr[j] = 0; // 清0
                for (int k = 0; k < 3; k++) {
                    if (k == j)
                        continue;
                    arr[j] += arr[k];
                }
            }
        }
        return arr[j];
    }

}
