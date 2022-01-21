package LeetCode;

import datastructure.TreeNode;

public class LowestCommonAncestor236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        TreeNode res = null;
        if(left != null && right != null)
            res =  root;
        else if (left != null)
            res = left;
        else if (right != null)
            res = right;
        return res;
    }
}
