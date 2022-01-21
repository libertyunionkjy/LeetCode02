package LeetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructure.TreeNode;

public class levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> node = new ArrayList<>();
            while (size-- != 0) {
                TreeNode pNode = queue.remove();
                node.add(pNode.val);
                if (pNode.left != null) {
                    queue.add(pNode.left);
                }
                if (pNode.right != null) {
                    queue.add(pNode.right);
                }
            }
            res.add(node);
        }
        return res;
    }
}
