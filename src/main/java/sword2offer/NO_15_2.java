package sword2offer;
/**
 * 题目描述：链表的中间的结点
 *      求链表的中间结点。如果链表结点总数是奇数，返回中间结点；如果
 *      结点总数是偶数，返回中间两个结点的任何一个都可以
 *
 * 解题思路：用两个指针，一个指针比另一个慢一步，当一个指针走到末尾的时候，
 *      另一个正好在中间
 */
public class NO_15_2 {

    public static void main(String[] args) {
        MNode node1 = new MNode("1");
        MNode node2 = new MNode("2");
        MNode node3 = new MNode("3");
        MNode node4 = new MNode("4");
        MNode node5 = new MNode("5");
        MNode node6 = new MNode("6");
        MNode node7 = new MNode("7");
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        System.out.println(findMid(node1).getData());
    }

    private static MNode findMid(MNode head) {
        if(head == null)
            return null;
        MNode slow = head;
        MNode fast = head;
        while(fast.getNext() != null && fast.getNext().getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

}
class MNode{
    private String data;
    private MNode next;

    public MNode(String data) {
        super();
        this.data = data;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public MNode getNext() {
        return next;
    }
    public void setNext(MNode next) {
        this.next = next;
    }

}
