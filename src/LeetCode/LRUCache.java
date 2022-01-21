package LeetCode;

import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, Node> entry;
    DoubleLinked doubleLink;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        this.entry = new HashMap<>();
        this.doubleLink = new DoubleLinked();
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!entry.containsKey(key))
            return -1;
        Node nod = entry.get(key);
        doubleLink.moveNodeHead(nod);
        return nod.val;
    }

    public void put(int key, int value) {

        if (entry.containsKey(key)) {
            Node nod = entry.get(key);
            doubleLink.modifyNode(nod, value);
        } else if (size < capacity) {
            Node newNode = new Node(key, value);
            this.doubleLink.addFirst(newNode);
            entry.put(key, newNode);
            size++;
        } else if(size == capacity){
            Node nod = doubleLink.removeLast();
            entry.remove(nod.key);
            Node newNode = new Node(key, value);
            this.doubleLink.addFirst(newNode);
            entry.put(key, newNode);
        }
    }
}


class DoubleLinked {
    public Node head, tail;

    DoubleLinked() {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node) {
        Node p = this.head.next;
        node.prev = this.head;
        node.next = this.head.next;
        this.head.next = node;
        p.prev = node;
    }

    //remove a node from Linked
    public Node removeNode(Node node) {
        Node pre = node.prev;
        Node nex = node.next;
        pre.next = nex;
        nex.prev = pre;
        node.next = null;
        node.prev = null;
        return node;
    }

    //put the node to head
    public void moveNodeHead(Node node) {
        removeNode(node);
        //move the node to head
        addFirst(node);
    }

    public void modifyNode(Node node, int val) {
        node.val = val;
        moveNodeHead(node);
    }

    public Node removeLast(){
        Node nod = tail.prev;
        removeNode(nod);
        return nod;
    }

}

class Node {
    public int key, val;
    public Node prev, next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

}
