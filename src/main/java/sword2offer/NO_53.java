package sword2offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 字符流中第一个不重复得字符
 * 请实现一个函数用来找出字符流中第一个只出现一次得字符。
 */
public class NO_53 {
    private int[] cnts = new int[256];
    private Queue<Character> queue = new LinkedList<Character>();

    public void insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1)
            queue.poll();
    }

    public char firstAppearOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
