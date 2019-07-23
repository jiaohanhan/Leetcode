package sword2offer;

/**
 * 题目描述：打印1到n位数
 *      输入数字n，按顺序打印从1到最大n位十进制数。
 *      比如输入3，则打印1、2...999
 *
 * 解题思路：注意一定要考虑单纯的打印小于10^(n+1)容易造成的溢出
 *
 */
public class NO_12 {

    public static void main(String[] args) {
        printNum(2);
    }

    private static void printNum(int n) {
        if (n < 0)
            throw new IllegalArgumentException("非法数字");

        int[] array = new int[n];
        printArray(array, 0);
    }

    private static void printArray(int[] array, int n) {
        if (n != array.length) {
            for (int i = 0; i < 10; i++) {
                array[n] = i;
                printArray(array, n + 1);
            }
        } else {
            boolean flag = false;
            for (int j = 0; j < array.length; j++) {
                if (array[j] != 0) {
                    flag = true;
                }
                if (flag) {
                    System.out.print(array[j]);
                }
            }
            if (flag)
                System.out.println();
        }

    }

}
