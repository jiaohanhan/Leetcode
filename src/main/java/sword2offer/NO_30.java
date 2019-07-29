package sword2offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小的k个数
 * 输入n个整数,返回最小的k个数字
 */
public class NO_30 {
    // quickSort
    public ArrayList<Integer> getLeastKNumber(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(input == null || k > input.length) return res;
        Arrays.sort(input);
        for (int i : Arrays.copyOfRange(input, 0, k)) {
            res.add(i);
        }
        return res;
    }

    // 堆 O(nlogk)
    public ArrayList<Integer> getLeastKNum(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int len = input.length;
        if(k > len || k == 0) return res;
        // PriorityQueue 默认实现的最小堆，改变排序方式实现最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < len; i++) {
            if (maxHeap.size() != k){
                maxHeap.offer(input[i]);
            } else if(maxHeap.peek() > input[i]){
                Integer tmp = maxHeap.poll();
                tmp = null;
                maxHeap.offer(input[i]);
            }
        }
        for (Integer i : maxHeap) {
            res.add(i);
        }
        return res;
    }

    // 冒泡 O(n*k)
    public ArrayList<Integer> getLeastNums(int[] arr, int k){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (k == 0 || k > arr.length) return res;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            res.add(arr[arr.length - i - 1]);
        }
        return res;
    }

}
