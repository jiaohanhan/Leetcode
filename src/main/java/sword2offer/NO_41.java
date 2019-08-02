package sword2offer;

/**
 * 数组中只出现一次的数字
 * 题目描述: 一个整型数组里除了两个数字之外，其他数字都出现了两次，找出只出现一次的数字。
 */
public class NO_41 {
    int num1 = 0;
    int num2 = 0;
    public void findNum(int[] arr){
        int diff = 0;
        for (int num : arr) {
            diff ^= num;
        }
        for (int num : arr) {
            if ((num & diff) == 0)
                num1 ^= num;
            else
                num2 ^= num;
        }
    }


}
