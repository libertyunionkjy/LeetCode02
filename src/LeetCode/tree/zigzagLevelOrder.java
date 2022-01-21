package LeetCode.tree;

import java.util.*;

import datastructure.TreeNode;
import sun.reflect.generics.tree.Tree;

public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        boolean isLeft = true;
        while (!queue.isEmpty()) {
            Deque<Integer> deque =new LinkedList<>();
            while (size-- != 0) {
                TreeNode pNode = queue.poll();
                if(isLeft){
                    deque.addLast(pNode.val);
                }else{
                    deque.addFirst(pNode.val);
                }
                if (pNode.left != null) {
                    queue.offer(pNode.left);
                }
                if (pNode.right != null) {
                    queue.offer(pNode.right);
                }
            }
            size = queue.size();
            res.add(new LinkedList(deque));
            isLeft = !isLeft;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
