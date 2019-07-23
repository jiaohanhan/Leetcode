package sword2offer;

/**
 * 题目描述：二进制中1的个数
 *      请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 *      例如把9表示成二进制1001，有2位是1.因此如果输入9，就输出2。
 *
 * 解题思路1：可以考虑(n & 1)结果如果是1，就累加结果，n >> 1迭代。但是这样
 *      输入的数据是负数的时候，就会陷入死循环，所以可以反过来做，flag=1，
 *      判断（n & flag)是不是等于flag，flag << 1 迭代，就可以避免死循环了
 *
 * 解题思路2：把一个整数减一，再和原整数做与运算，会把该整数最右边的一个1变成0
 *      那么一个整数的二进制中有多少个1，就可以进行多少次这样的运算
 *
 */
public class NO_10_1 {
    public static void main(String[] args) {
        System.out.println(count1(7));
        System.out.println(count2(7));
    }

    public static int count1(int n) {
        int flag = 1;
        int result = 0;
        while (flag > 0) {
            if ((n & flag) == flag)
                result++;

            flag <<= 1;
        }
        return result;
    }

    public static int count2(int n) {
        int result = 0;
        while (n != 0) {
            result++;
            n = (n - 1) & n;
        }
        return result;
    }
}

