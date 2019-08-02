package sword2offer;

/**
 * 不做加减乘除做加法
 * 题目描述：写一个函数，求两个整数的和，要求不使用加减乘除
 */
public class NO_49 {
    private int add(int num1, int num2) {
        while (num2 != 0) {
            int tmp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = tmp;
        }
        return num1;
    }
}
