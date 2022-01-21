//import org.junit.Test;
import datastructure.ListNode;

public class Main {

//    @Test
    public void isPalindrome(){
        ListNode head = new ListNode(1);
        ListNode pre = head;
        for (int i = 0; i < 3; i++) {
            ListNode p = new ListNode(i+2);
            pre.next = p;
            pre = p;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.print("slow = " + slow.val);
    }
}
