package offer;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> leftQue = new LinkedList<>();
        Queue<TreeNode> rightQue = new LinkedList<>();
        leftQue.offer(root.left);
        rightQue.offer(root.right);
        while (!leftQue.isEmpty() && !rightQue.isEmpty()){
            // 可以保证这两个节点都是非空的
            TreeNode leftNode = leftQue.poll();
            TreeNode rightNode = rightQue.poll();

            if(!isSame(leftNode,rightNode)) return false;

            if(leftNode.left != null) leftQue.offer(leftNode.left);
            if(leftNode.right != null) leftQue.offer(leftNode.right);
            if(rightNode.right != null) rightQue.offer(rightNode.right);
            if(rightNode.left != null) rightQue.offer(rightNode.left);
        }
        if( !(leftQue.isEmpty() && rightQue.isEmpty()) ){
            return false;
        }
        return true;
    }

    boolean isSame(TreeNode A,TreeNode B) {
        if(A.val != B.val) return false;
        boolean Aleft = A.left != null;
        boolean Aright = A.right != null;
        boolean Bleft = B.left != null;
        boolean Bright = B.right != null;
        if(Aleft != Bright || Aright != Bleft) return false;
        return true;
    }
}
