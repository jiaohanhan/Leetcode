package sword2offer;


/**
 * 题目描述：在O(1)时间内删除链表结点
 *      给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间
 *      删除该结点。
 *
 * 解题思路：删除单链表结点的思路有两种，一种就是顺序遍历链表找到要删除的
 *      的结点的上一个结点，把其指针指向要删除节点的下一个结点；第二种思路
 *      把要删除结点的下一个结点的值赋给要删除的结点，并把赋好值的结点的指针
 *      指向下一个个结点。在本题中，采用第二种思路，这种思路好处在于删除的
 *      结点只需要常数时间，但是基于这个结点一定在链表中，这样也给了这个函数
 *      的调用者增加了O(n)的复杂度来确保要删除结点是不是在链表中
 *
 */

public class NO_13 {
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
        delete(node1,node4);
        Node node = node1;
        while(node != null){
            System.out.println(node.getData());
            node = node.getNext();
        }

    }

    public static void delete(Node head, Node delNode){
        //如果是尾结点，只能遍历删除
        if(delNode.getNext() == null){
            while(head.getNext() != delNode){
                head = head.getNext();
            }

            Node node = head.getNext();
            node = null;
        }else if(head == delNode){
            head = null;
        }else{
            delNode.setData(delNode.getNext().getData());
            delNode.setNext(delNode.getNext().getNext());
        }
    }

    static class Node{
        String data;
        Node next;

        public Node(String s){
            this.data = s;
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

