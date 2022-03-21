package datastructure;


import org.junit.jupiter.api.Test;

public class Skiplist {

    final double UP_Probability =  0.5;
    final int MAX_LEVEL = 16;

    // 最高有多少层
    int level_count = 1;

    Node head=new Node();

    Skiplist() {

    }

    class Node{
        int val = -1;
        int maxLevel = 0;
        // 在每一层上面的下一个节点
        Node[] forward = new Node[MAX_LEVEL];

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(val);
            builder.append(";  levels: ");
            builder.append(maxLevel);
//            builder.append("; levels: ");
            builder.append(" }");

            return builder.toString();
        }

    }

    public void printAll() {
        Node p = head;
        while (p.forward[0] != null) {
            System.out.print(p.forward[0] + " ");
            p = p.forward[0];
        }
        System.out.println();
    }


    int randomLevel(){
        int k = 1;
        while (Math.random() < UP_Probability && k < MAX_LEVEL) {
            k++;
        }
        return k;
    }

    public void add(int num) {
        int level = randomLevel();
        Node newNode =  new Node();
        newNode.val = num;
        newNode.maxLevel = level;
        Node[] update = new Node[level];
        for (int i = 0; i < level; i++) {
            update[i] = head;
        }

        Node p = head;
        for (int i = level - 1; i >= 0; i--) {
            while (p.forward[i] != null && p.forward[i].val < num) {
                p = p.forward[i];
            }
            // p是第i层上小于num的最大的元素
            update[i] = p;
        }

        for (int i = 0; i < level; i++) {
            //update[i]是p，是一个Node，需要指定到第几层
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }

        if(level_count < level) level_count = level;
    }

    public boolean erase(int num) {
        // 保存每一层上num对应的前一个元素
        Node[] update = new Node[level_count];
        Node p = head;
        for (int i = level_count - 1 ; i >= 0 ; i--) {
            while (p.forward[i] != null && p.forward[i].val < num) {
                p = p.forward[i];
            }
            update[i] = p;
        }

        // 如果没有这个数，直接返回false
        if (p.forward[0] == null || p.forward[0].val > num) {
            return false;
        }

        // 如果有这个数，逐层删除，update[i]有两种可能：1.update[i]已经是最后一个元素，并且这个元素肯定不是num；2.update[i]是每一层上小于num的最大的元素
        for (int i = level_count - 1; i >= 0; i--) {
            // 对于第一种情况，不需要处理，第二种情况需要处理
            if (update[i].forward[i] != null && update[i].forward[i].val == num) {
                update[i].forward[i] = update[i].forward[i].forward[i];
            }
        }

        while (level_count > 1 && head.forward[level_count] == null) {
            level_count--;
        }
        return true;
    }

    public boolean search(int target) {
        Node p = head;
        for (int i = level_count - 1; i >= 0; i--) {
            // p.forward代表的是p的下一个元素   退出循环的条件是：p的下一个元素是空或者p的下一个元素的值大于等于target
            while (p.forward[i] != null && p.forward[i].val < target) {
                p = p.forward[i];
            }
        }
        // 对于退出循环的两个条件，1.空的话，能走到null，就代表目前这个节点的值是小于target的；2.只有存在下一个节点并且等于target才是我们要的结果
        if (p.forward[0] != null && p.forward[0].val == target) {
            return true;
        }
        return false;
    }
}
