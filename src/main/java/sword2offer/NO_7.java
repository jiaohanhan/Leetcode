package sword2offer;

import java.util.Stack;

/**
 * 题目描述：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数
 *      appendTail和deleteHead，分别完成在队列尾部插入结点和在队列头
 *      部删除结点的功能
 *
 * 解题思路：给出的结构中含有两个栈，s1,s2，对于进队操作，可以直接向s1中
 *      压栈，那么对于出队来说就需要s2的参与，把s1中的元素全部弹出压入s2
 *      栈中，原先栈底的元素即队列的头元素，就跑到栈顶了，便可以直接进行
 *      弹出栈的操作，也就实现了出队的操作
 *
 */
public class NO_7 {

    private Stack s1 = new Stack();
    private Stack s2 = new Stack();

    public static void main(String[] args) {
        NO_7 queue = new NO_7();
        queue.appendTail("a");
        queue.appendTail("b");
        queue.appendTail("c");
        queue.deleteHead();
        queue.deleteHead();
        queue.deleteHead();
        queue.deleteHead();
    }

    @SuppressWarnings("unchecked")
    public void appendTail(Object x) {
        s1.push(x);
    }

    @SuppressWarnings("unchecked")
    public void deleteHead() {
        if (s1.size() == 0 && s2.size() == 0)
            try {
                throw new Exception("队列为空");
            } catch (Exception e) {
                e.printStackTrace();
            }
        else {
            if (s2.size() != 0) {
                System.out.println(s2.pop().toString());
            } else {
                while (s1.size() > 0)
                    s2.push(s1.pop());
                System.out.println(s2.pop().toString());
            }
        }

    }

}
