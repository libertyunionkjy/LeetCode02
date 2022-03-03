package LeetCode;

import datastructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKLists23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        Queue<ListNode> q = new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val < o2.val)
                    return -1;
                else if(o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        for (ListNode list : lists) {
            if(list != null)
                q.offer(list);
        }
        while(!q.isEmpty()){
            ListNode newNode = q.poll();
            if(newNode.next != null) q.offer(newNode.next);
            ptr.next = newNode;
            ptr = ptr.next;
        }
        return dummy.next;
    }
}
