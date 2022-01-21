package LeetCode;

import datastructure.ListNode;
import datastructure.TreeNode;

import java.time.temporal.Temporal;

public class Flatten114 {
    /**
     * 我的解法
     */
    TreeNode last;

    public void flattenMyAnswer(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null) {
            flatten(root.left);
            last = root.left;
            while (last != null && last.right != null)
                last = last.right;
            last.right = root.right;
            root.right = root.left;
            root.left = null;
            flatten(last.right);
        } else if (root.left == null) {
            flatten(root.right);
        }
    }

    /**
     * labuladong的解法
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.left);
        flatten(root.right);
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        root.left = null;
        root.right = leftNode;
        TreeNode p = root;
        while (p.right != null)
            p = p.right;
        p.right = rightNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        Flatten114 sol = new Flatten114();
        sol.flatten(root);
    }
}
