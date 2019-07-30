package sword2offer;

import java.util.Stack;
/**
 * 题目描述：输入一个链表的头结点，从尾到头反过来打印出每个结点的值
 *
 * 解题思路1：递归反转，用头指针和next找到最后一个结点，逆序打印，缺点
 *      链表很长的时候，容易造成溢出。优点：没有改变链表的结构。
 *
 * 解题思路2：直接改变链表的结构，变成逆向的链表，即改变next指针的取反
 *
 * 解题思路3：用栈保存每一步遍历链表得到的结点，再弹出栈
 *
 *
 */
public class NO_5 {
    public static void main(String[] args) {
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        System.out.print("解题思路1：");
        reverse1(node1);
        System.out.println();

        System.out.print("解题思路3：");
        reverse3(node1);
        System.out.println();

        System.out.print("解题思路2：");
        reverse2(node1);

    }

    // 递归反转
    public static void reverse1(Node head) {
        if (head != null) {
            if (head.getNext() != null)
                reverse1(head.getNext());   // 这一步其实就是head = head.getNext();
            // reverse1(head);
        }
        System.out.print(head.getData() + " ");

    }

    // 非递归反转
    public static void reverse2(Node head) {
        Node pre = head;
        Node cur = head.getNext();
        Node temp;
        while (cur != null) {
            temp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = temp;
        }
        head.setNext(null);

        while (pre != null) {
            System.out.print(pre.getData() + " ");
            pre = pre.getNext();
        }
    }

    /**
     *    利用栈缓存每一步的得到的结点
     */
    private static void reverse3(Node head) {
        Stack<Node> stack = new Stack();
        while (head != null) {
            stack.push(head);
            head = head.getNext();
        }
        while (!stack.isEmpty())
            System.out.print(stack.pop().getData() + " ");
    }


    static class Node {
        private String data;
        private Node next;

        public Node(String data) {
            super();
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

}


