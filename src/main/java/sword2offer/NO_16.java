package sword2offer;
/**
 * 题目描述：反转链表
 *      定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的
 *      头结点。
 *
 * 解题思路：先保证代码的鲁棒性，反转策略就是
 */
public class NO_16 {

    public static void main(String[] args) {
        MyNode node1 = new MyNode("1");
        MyNode node2 = new MyNode("2");
        MyNode node3 = new MyNode("3");
        MyNode node4 = new MyNode("4");
        MyNode node5 = new MyNode("5");
        MyNode node6 = new MyNode("6");
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        System.out.println(reverseList(node1).getData());
    }

    public static MyNode reverseList(MyNode head) {
        if (head == null)
            return null;
        if (head.getNext() == null)
            return head;

        MyNode preMyNode = null;
        MyNode curMyNode = head;
        MyNode reversedHead = null;

        while (curMyNode.getNext() != null) {
            MyNode nextMyNode = curMyNode.getNext();
            if (nextMyNode == null)
                reversedHead = nextMyNode;
            MyNode temp = curMyNode.getNext();
            temp = preMyNode;
            preMyNode = curMyNode;
            curMyNode = nextMyNode;
        }
        return curMyNode;
    }

}

class MyNode {
    private String data;
    private MyNode next;

    public MyNode(String data) {
        super();
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

}
