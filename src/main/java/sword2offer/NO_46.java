package sword2offer;

import java.util.Arrays;

/**
 * 扑克牌顺子
 * 随机五张牌是不是，判断是不是顺子，大小王万能
 */
public class NO_46 {
    public boolean isContinuous(int[] nums){
        int numOfZero = 0;
        int numOfInterval = 0;
        int length = nums.length;
        if (length == 0) return false;
        Arrays.sort(nums);
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == 0){
                numOfZero++;
                continue;
            }
            if (nums[i] == nums[i + 1]) {
                return false;
            }
            numOfInterval += nums[i + 1] - nums[i] - 1;
        }
        if (numOfZero >= numOfInterval) {
            return true;
        }
        return false;
    }
}
