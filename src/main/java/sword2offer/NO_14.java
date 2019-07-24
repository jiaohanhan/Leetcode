package sword2offer;


/**
 * 题目描述：调整数组顺序使奇数位于偶数前面
 *      输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
 *      奇数位于数组的前半部分，所有偶数位于数组的后半部分
 *
 * 解题思路：用两个下标，一个从前向后找第一个遇到的偶数，第二个从后向前找
 *      第一个遇到的奇数，交换，当两个下标相遇结束。
 */
public class NO_14 {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        adjust(arr);
        for (int i : arr)
            System.out.print(i + " ");

    }

    public static void adjust(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new NullPointerException("空数组");
        int i = 0;
        int j = arr.length - 1;
        int temp = 0;
        while (i < j) {
            if (i<j &&(arr[i] & 0x1) == 1)
                i++;

            if (i<j && (arr[j] & 0x1) == 0)
                j--;

            if(i<j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
    }
}

