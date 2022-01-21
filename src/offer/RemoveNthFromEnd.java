package offer;

import datastructure.ListNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if( head == null )
            return null;
        ListNode node = new ListNode(0,head);
        ListNode first = head, last = node;
        for(int i = 1; i <= n; i++){
            first = first.next;
        }
        while(first != null) {
            first = first.next;
            last = last.next;
        }
        last.next = last.next.next;
        return node.next;
    }
}
