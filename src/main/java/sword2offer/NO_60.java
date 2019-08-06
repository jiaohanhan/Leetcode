package sword2offer;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 */
public class NO_60 {
    private int count = 0;
    private PriorityQueue<Integer> max = new PriorityQueue<Integer>((o1, o2) -> (o2 - o1));
    private PriorityQueue<Integer> min = new PriorityQueue<>();

    public void insert(Integer num) {
        if (count % 2 == 0) {
            max.add(num);
            min.add(max.poll());
        }else {
            min.add(num);
            max.add(min.poll());
        }
        count++;
    }

    public double getMedian() {
        if (count % 2 == 0)
            return (min.peek() + max.peek()) / 2.0;
        else
            return min.peek();
    }
}
