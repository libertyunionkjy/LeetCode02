package hot100;

import datastructure.ListNode;

public class MidAddTwoNumbers02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode p = res;
        int flag = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + flag;
            flag = 0;
            if(sum >= 10){
                flag = 1;
                sum = sum - 10;
            }
            p.next = new ListNode(sum);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int sum = l1.val + flag;
            flag = 0;
            if(sum >= 10){
                flag = 1;
                sum = sum - 10;
            }
            p.next = new ListNode(sum);
            p = p.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int sum = l2.val + flag;
            flag = 0;
            if(sum >= 10){
                flag = 1;
                sum = sum - 10;
            }
            p.next = new ListNode(sum);
            p = p.next;
            l2 = l2.next;
        }
        if(flag == 1)
            p.next = new ListNode(1);
        return res.next;
    }
}
