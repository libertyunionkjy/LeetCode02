package offer;

/**
 * 环形链表的两道题
 * @date: 12-03-2020
 */
public class hasCycle {
    /**
     * https://leetcode-cn.com/problems/linked-list-cycle/
     * @param head
     * @return 是否有环
     */
    public boolean hasCycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head, fast = head.next;
        while(slow != fast){
            if(fast.next == null || fast.next.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * https://leetcode-cn.com/problems/linked-list-cycle-ii/
     */
    public ListNode detectCycle(ListNode head){
        if(head == null || head.next == null)
            return null;
        //第一次相遇
        /**
         * 这里的first和slow的路程有严格的长度关系，所以起始时fast必须要和slow一样
         */
        ListNode slow = head, fast = head;
        do{
            if(fast.next == null || fast.next.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }while(slow != fast);

        //此时fast == slow
        fast = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
