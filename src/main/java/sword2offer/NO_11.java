package sword2offer;
/**
 * 题目描述：数值的整数次方
 *      实现函数double power(double base, int exponent),求base的exponent次方。
 *      不得使用库函数，同时不需要考虑大数问题。
 *
 * 解题思路：注意指数可以正，负，0，基数是否为0；在计算的时候注意比较double类型的
 *      时候不能用==号，计算的时候可以进行优化
 *
 */
public class NO_11 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(power(2.0, 10));
    }

    public static double power(double base, int exponent) {
        double result = 0.0;
        if (equal(base, 0.0) && exponent < 0) {
            throw new IllegalArgumentException("0的负数次幂没有意义");
        }

        if (exponent < 0) {
            result = 1.0 / powerWithExpoment(base, -exponent);
        } else {
            result = powerWithExpoment(base, exponent);
        }

        return result;
    }

    private static double powerWithExpoment(double base, int exponent) {
        if (exponent == 0)
            return 1.0;
        if (exponent == 1)
            return base;
        // //这是线性时间
        // double result = 1.0;
        // for(int i=0;i<exponent;i++)
        // result *= base;

        // 优化
        double result = powerWithExpoment(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1)
            result *= base;
        return result;
    }

    private static boolean equal(double num1, double num2) {
        if (Math.abs(num1 - num2) < 0.0000001)
            return true;
        else
            return false;
    }
}
