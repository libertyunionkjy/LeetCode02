package LeetCode;

import datastructure.ListNode;

public class isPalindrome234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        ListNode slow = findMidNode(head);
        ListNode tail = reverse(slow);
        ListNode right = tail;
        ListNode left = head;
        while(right != null){
            if(left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        reverse(tail);
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null, p = head, next;
        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    ListNode findMidNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        return slow;
    }
}
