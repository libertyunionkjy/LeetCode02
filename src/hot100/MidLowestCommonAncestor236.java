package hot100;

import datastructure.TreeNode;

public class MidLowestCommonAncestor236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root.left == null && root.right == null && root != p && root != q)
            return null;
        else if( root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null)
            return root;
        else if(left != null)
            return left;
        else if(right != null)
            return right;
        return null;
    }
}
