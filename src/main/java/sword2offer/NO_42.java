package sword2offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为S的连续整数序列
 * 题目描述：输出所有和为S的连续正数序列
 */
public class NO_42 {
    public List<List<Integer>> findContinueSequence(int sum){
        List<List<Integer>> res = new ArrayList();
        if (sum <= 1) return res;
        int small = 1, big = 2;
        while (small != (1 + sum) / 2) {
            int curSum = sumOfList(small, big);
            if (curSum == sum){
                List<Integer> list = new ArrayList<Integer>();
                for (int i = small; i <= big ; i++) {
                    list.add(i);
                }
                res.add(list);
                ++small;
                ++big;
            } else if (curSum < small) {
                big++;
            }else {
                small++;
            }
        }
        return res;
    }

    private int sumOfList(int small, int big) {
        int sum = 0;
        for (int i = small; i <= big; i++) {
            sum += i;
        }
        return sum;
    }
}
