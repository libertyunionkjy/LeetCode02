package offer;


/**
 * @date: 12-01-2020
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode res = new ListNode(0);
        ListNode result = res;
        int sum = 0, carry = 0;
        //1.l1 not null && l2 not null
        while (p != null && q != null) {
            sum = p.val + q.val + carry;
            carry = sum / 10;
            res.next = new ListNode(sum % 10);
            res = res.next;
            p = p.next;
            q = q.next;
        }
        //2.(l1 || l2) is null
        while (p != null || q != null) {
            if (p != null) {
                sum = p.val + carry;
                carry = sum / 10;
                p = p.next;
            } else {
                sum = q.val + carry;
                carry = sum / 10;
                q = q.next;
            }
            res.next = new ListNode(sum % 10);
            res = res.next;
        }
        //3.l1 is null && l2 is
        // null && carry is true
        if (carry == 1) {
            res.next = new ListNode(1);
        }
        return result.next;
    }
}
