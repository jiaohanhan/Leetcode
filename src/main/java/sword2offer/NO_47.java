package sword2offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 圆圈中最后剩下的数字
 * 0，1，2，....n 排成一个圆圈，从数字0开始，每次从
 */
public class NO_47 {

    public int findLastNum(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int[] arr = new int[n];
        int i = -1, step = 0, count = n;
        while (count > 0) {
            i++;
            if(i >= n) i = 0;
            if (arr[i] == -1) continue;
            step++;
            if (step == m) {
                arr[i] = -1;
                step = 0;
                count--;
            }
        }
        return i;
    }

    public int findTheLastNumber(int n, int m) {
        if (m == 0 || n == 0) {
            return -1;
        }
        List<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            data.add(i);
        }
        int index = -1;
        while (data.size() > 1) {
            index = (index + m) % data.size();
            data.remove(index);
            index--;
        }
        return data.get(0);
    }

}
