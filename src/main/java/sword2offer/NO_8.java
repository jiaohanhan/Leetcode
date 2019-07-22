package sword2offer;

/**
 * 题目描述：把一个数组最开始的若干元素搬到数组的末尾，称之为数组的旋转。
 *      输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数
 *      组{3，4，5，1，2}为{1，2，3，4，5}的一个旋转，该数组的最小值为1
 *
 * 解题思路：假设我们持有两个指针，第一个指针left指向前面的递增数组的元素，
 *      第二个指针right指向第二个递增数组的的元素，初始化的时候第一个指针
 *      指向数组的第一个元素，第二个指针指向数组的最后一个元素，用二分法的
 *      思想，比较左右指针和中间元素mid的大小，要是比左边元素大的话就让
 *      left=mid,否则就让right=mid;要注意{2，2，2，0，1，2}这种情况的处理
 *      当left,mid,right指向的数据相等的时候就要处理这种情况了。
 *
 */
public class NO_8 {
    public static void main(String[] args) throws Exception {
        int[] arr = {3,4,5,1,2};
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] arr) throws Exception {
        if (arr == null || arr.length == 0)
            throw new Exception("数组为空");

        int left = 0;
        int right = arr.length - 1;

        if (arr[right] > arr[left])
            throw new Exception("非旋转数组");

        while (left < right) {
            int mid = (left + right) / 2;

            // 对于{1，0，1，1，1，1}之类情况的特殊处理
            if (arr[mid] == arr[left] && arr[left] == arr[right])
                return searchMin(arr, left, right);

            if (right - left == 1)
                break;

            if (arr[mid] >= arr[left])
                left = mid;
            else
                right = mid;
        }
        return arr[right];

    }
    private static int searchMin(int[] arr, int left, int right) {
        int result = arr[left];
        for (int i = left + 1; i <= right; ++i)
            if (arr[i] < result)
                result = arr[i];
        return result;
    }
}

