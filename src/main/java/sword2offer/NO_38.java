package sword2offer;

/**
 * 数字在排序数组中出现的次数
 * 题目描述：统计一个数字在排序数组中出现的次数
 */
public class NO_38 {
    public int getNumberOfK(int[] arr, int k) {
        int res = 0;
        int flag = 0;
        for (int i : arr) {
            if (i == k) {
                res++;
                flag = 1;
            }else if (i != k && flag == 1){
                return res;
            }
        }
        return res;
    }

    // 二分法
    public int getNumberOfk1(int[] arr, int k) {
        int length = arr.length;
        if (length == 0) return length;
        int firstK = getFirstK(arr, k, 0, length - 1);
        int lastK = getLastK(arr, k, 0, length - 1);
        if (firstK != -1 && lastK != -1) {
            return lastK - firstK + 1;
        }
        return 0;
    }
    // 递归
    private int getFirstK(int[] arr, int k, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) >> 1;
        if (arr[mid] > k){
            return getFirstK(arr, k, start, mid - 1);
        }else if (arr[mid] < k){
            return getFirstK(arr, k, mid + 1, end);
        } else if (mid - 1 >= 0 && arr[mid - 1] == k) {
            return getFirstK(arr, k, start, end);
        }else {
            return mid;
        }
    }

    // 循环
    private int getLastK(int[] arr, int k, int start, int end) {
        int len = arr.length;
        int mid = (start + end) >> 1;
        while (start <= end) {
            if (arr[mid] > k) {
                end = mid - 1;
            } else if (arr[mid] < k) {
                start = mid + 1;
            } else if (mid + 1 < len && arr[mid + 1] == k) {
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }


}
