package sword2offer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 滑动窗口的最大值
 */
public class NO_61 {
    public List<Integer> maxInWindows(int[] nums, int size) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || size > nums.length || size < 1) return res;
        // 大顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int num: nums) {
            heap.add(num);
        }
        res.add(heap.peek());
        for (int i = 1, j = i + size - 1; j < nums.length; j++, i++) {
            heap.remove(nums[i - 1]);
            heap.add(nums[j]);
            res.add(heap.peek());
        }
        return res;
    }
}
