package sword2offer;

/**
 * 题目描述：写一个函数，输入n，求斐波那契数列的第n项
 *
 * 解题思路：递归最直白，效率有限；可以动态规划，就是有点浪费空间，
 *          也可以保存上一步的值再求解。
 *          当然O(logn)的复杂度的算法也是有的
 *
 */
public class NO_9 {

    public static void main(String[] args) {
        System.out.println(fibnacci(10));
    }

    public static long fibnacci(int n) {
        long[] a = { 0, 1 };
        if (n < 2)
            return a[n];

        long fib1 = 0;
        long fib2 = 1;
        long fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibN;
        }
        return fibN;
    }
}
