package offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class ReversePrint {
    public int[] reversePrint(ListNode head) {
        ListNode tmp = head;
        Deque<Integer> stack = new LinkedList<>();
        while (tmp != null) {
            stack.push(tmp.val);
            tmp = tmp.next;
        }
        //小坑，必须要用一个变量把stack的size记录下来先，直接用stack.size()方法
        //判断的话，因为每次方法的返回值是在变动的（一直在出栈），所以结果会错误
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
