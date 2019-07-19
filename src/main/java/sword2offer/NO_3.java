package sword2offer;


/**
 * 题目:在一个二维数组中，每一行都按照从左到右的递增顺序排序，
 *  每一列都按照从上到下的递增顺序排序。请完成一个函数，输入
 *  这样一个二位数组和一个整数，判断数组中是否含有该整数,含有
 *  就返回true，否则返回false。
 *
 * 解题思路：首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找结束；
 *  如果该数字大于要查找的数字，剔除这个数字所在的列；
 *  如果该数字小于要查找的数字，剔除这个数字所在的行。
 *  再从右上角的数字开始，每一步都可以缩小查找范围，
 *  直到找到数字，或者查找范围为空。（注意不能选取左上角或者右下角的数据开始）
 *
 */
public class NO_3 {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 8, 9 },
                { 2, 4, 9, 12 },
                { 4, 7, 10, 13 },
                { 6, 8, 11, 15 } };
        System.out.println(search(arr, 4));
    }

    private static boolean search(int[][] arr, int key) {
        int i = 0;
        int j = arr[0].length - 1;
        while (i <= arr.length - 1 && j >= 0) {
            if (arr[i][j] == key)
                return true;

            if (arr[i][j] > key)
                j--;
            else
                i++;
        }
        return false;
    }
}
