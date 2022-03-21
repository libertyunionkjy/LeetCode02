package exam.interview0310;

import datastructure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(0);

        head.next = new Node(1);
        head.next.random = head;
        head.random = head.next;
        copyRandomList(head);
    }

    public static Node copyRandomList(Node head) {
        Node ptr;
        // 记录每个Node在链表中的下标；
        int i = 0;
        Map<Node,Integer> map = new HashMap<>();
        for(ptr = head; ptr != null; ptr = ptr.next){
            map.put(ptr,i);
            i++;
        }
        for(Node e : map.keySet()){
            System.out.println(e.val);
        }
        // 先把所有节点创建出来，放在一个数组中
        Node[] arr = new Node[map.size()];

        i = 0;
        for(ptr = head; ptr != null; ptr = ptr.next){
            arr[i] = new Node(ptr.val);
            if(i != map.size() - 1){
                arr[i].next = arr[i + 1];
            }
            if(ptr.random != null){
                int index = map.get(ptr.random);
                arr[i].random = arr[index];
            }
            i++;
        }
        return arr[0];
    }
}
