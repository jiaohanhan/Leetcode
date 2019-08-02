package sword2offer;

/**
 * 求1+2+3+...+n
 * 题目描述：不能使用乘除法，for while if else switch case等关键字及条件判断语句
 *
 */
public class NO_48 {
    private int sum(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += sum(n - 1)) > 0);
        return sum;
    }

    private int sum2(int n) {
        return helper(n);
    }

    private int helper(int n) {
        try {
            int i = 1 % n;
            return n + sum(n - 1);
        } catch (Exception e) {
            return 0;
        }
    }
}
