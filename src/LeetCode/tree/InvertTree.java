package LeetCode.tree;

import datastructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        return helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if (root == null)
            return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        helper(root.left);
        helper(root.right);
        return root;
    }
}
