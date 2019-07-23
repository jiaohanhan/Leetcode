package sword2offer;

/**
 * 题目描述：
 *      判断一个数是否是2的整数次方，是就输出yes,否则就输出no
 *
 * 解题思路：如果一个数是2的整数次方，那么这个数的二进制一定只包含一个1
 *      ，也就是说，这个整数减去1和自己做与运算，就会变成0
 *
 */
public class NO_10_2 {
    public static void main(String[] args) {
        judge(8);
        judge(5);
    }

    public static void judge(int n) {
        if (((n - 1) & n) == 0)
            System.out.println("yes");
        else
            System.out.println("no");
    }

}
