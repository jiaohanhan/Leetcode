package sword2offer;

/**
 * 题目描述：
 *      输入两个整数m和n，计算需要改变m的二进制表示中的多少位
 *      才能得到n.
 *
 * 解题思路：先做异或，然后统计异或结果中1的位数
 *
 */
public class NO_10_3 {
    public static void main(String[] args) {
        System.out.print(count(1, 3));
    }
    public static int count(int m, int n) {
        int result = 0;
        n = m ^ n;
        while (n > 0) {
            ++result;
            n = n & (n - 1);
        }
        return result;
    }

}
