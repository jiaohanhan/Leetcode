package sword2offer;
/**
 * 题目描述：链表中倒数第k个结点
 *      输入一个链表，输出该链表中倒数第k个结点，规定链表从1开始计数，
 *      。例如一个链表有6个结点，那么从头开始计数依次是1、2、3、4、5、6
 *      这个链表的倒数第3个结点是值为4的结点。
 *
 * 解题思路：直观解法，就是把链表遍历两次，第一次遍历出链表长度，第二次
 *      定位出k所在的位置。在遍历一次就定位到k所在位置，只需要定义两个指针
 *      一个先跑k步，另一个指针再出发，当第一个指针到了链表尾部，那么第二个
 *      指针就正好定位到k的位置，注意代码的鲁棒性，考虑空指针，链表结点少于k，
 *      以及输入k为0的情况
 */
public class NO_15_1 {

    public static void main(String[] args) {
        My_Node node1 = new My_Node("1");
        My_Node node2 = new My_Node("2");
        My_Node node3 = new My_Node("3");
        My_Node node4 = new My_Node("4");
        My_Node node5 = new My_Node("5");
        My_Node node6 = new My_Node("6");
        My_Node node7 = new My_Node("7");
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        System.out.println(findKthMy_NodeFromTail(node1, 4));
    }

    public static String findKthMy_NodeFromTail(My_Node head, int k){
        if(head == null)
            return null;
        if(k==0){
            System.out.println("k要求从1开始");
            return null;
        }

        My_Node temp1 = head;
        for(int i = 0;i<k-1;i++){
            if(temp1.getNext() == null){
                System.out.println("k不应该大于链表长度的");
                return null;
            }
            temp1 = temp1.getNext();
        }

        My_Node temp2 = head;
        while(temp1.getNext() != null){
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();

        }
        return temp2.getData();
    }

    static class My_Node{
        private String data;
        private My_Node next;

        public My_Node(String data) {
            this.data = data;
        }
        public String getData() {
            return data;
        }
        public void setData(String data) {
            this.data = data;
        }
        public My_Node getNext() {
            return next;
        }
        public void setNext(My_Node next) {
            this.next = next;
        }
    }
}


