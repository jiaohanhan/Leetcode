package sword2offer;

/**
 * 题目描述：合并两个排序的链表
 *      输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 *
 * 解题思路：注意边界检验
 *
 */
public class NO_17 {

    public static void main(String[] args) {
        M_Node M_Node1 = new M_Node(1);
        M_Node M_Node2 = new M_Node(2);
        M_Node M_Node3 = new M_Node(3);
        M_Node M_Node4 = new M_Node(4);
        M_Node M_Node5 = new M_Node(5);
        M_Node M_Node6 = new M_Node(6);
        M_Node M_Node7 = new M_Node(7);
        M_Node M_Node8 = new M_Node(8);
        M_Node M_Node9 = new M_Node(9);
        M_Node M_Node10 = new M_Node(10);
        M_Node M_Node11 = new M_Node(11);
        //第一个链表
        M_Node1.setNext(M_Node3);
        M_Node3.setNext(M_Node5);
        M_Node5.setNext(M_Node7);
        M_Node7.setNext(M_Node9);
        M_Node9.setNext(M_Node11);

        //第二个链表
        M_Node2.setNext(M_Node4);
        M_Node4.setNext(M_Node6);
        M_Node6.setNext(M_Node8);
        M_Node8.setNext(M_Node10);

        print(merge(M_Node1, M_Node2));

    }

    public static M_Node merge(M_Node head1,M_Node head2){
        if(head1 == null)
            return head2;
        else if(head2 == null)
            return head1;

        M_Node mergeM_Node = null;
        if(head1.getData() < head2.getData()){
            mergeM_Node = head1;
            merge(head1.getNext(), head2);
        }else{
            mergeM_Node = head2;
            merge(head1, head2.getNext());
        }
        return mergeM_Node;
    }

    private static void print(M_Node root){
        if(root != null){
            System.out.println(root.getData());
            print(root.getNext());
        }
    }

    static class M_Node{
        private int data;
        private M_Node next;

        public M_Node(int data) {
            super();
            this.data = data;
        }
        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
        public M_Node getNext() {
            return next;
        }
        public void setNext(M_Node next) {
            this.next = next;
        }
    }
}



