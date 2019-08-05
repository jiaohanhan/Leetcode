package sword2offer;

/**
 * 删除链表中的重复节点
 * 题目描述；在一个排序链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *      1->2->3->3->4      1->2->4
 */
public class NO_55 {
    /**
     * 递归
     */
    public ListNode deleteDuplication(ListNode pHead){
        if (pHead == null || pHead.next == null) return pHead;
        if (pHead.val == pHead.next.val){
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点，找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            return deleteDuplication(pNode);
        }else {
            // 当前结点不是重复结点
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    private ListNode delete(ListNode pHead) {
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode p = pHead;
        ListNode last = dummy;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p != null && p.val == val) {
                    p= p.next;
                }
                last.next = p;
            }else {
                last = p;
                p = p.next;
            }
        }
        return dummy.next;
    }


    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){this.val = val;}
    }
}
