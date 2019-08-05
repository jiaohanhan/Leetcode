package sword2offer;

/**
 * 数组中重复的数字
 * 题目描述：在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 *      数组中某些数字是重复的，但不知道有几个数字是重复的。
 *      也不知道每个数字重复几次。请找出数组中任意一个重复的数字
 */
public class NO_51 {
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        boolean[] flags = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (flags[nums[i]] == true ) {
                duplication[0] = nums[i];
                return true;
            }
            flags[nums[i]] = true;
        }
        return false;
    }
}
