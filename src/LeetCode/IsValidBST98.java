package LeetCode;

import datastructure.TreeNode;

import java.time.temporal.Temporal;

public class IsValidBST98 {
    //1.左右子树都是BST
    //2.root比左边
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }

    //限定以root为根的子树必须满足：max.val > root.val > min.val
    boolean helper(TreeNode root, TreeNode min, TreeNode max){
        if(root == null)
            return true;
        if(min != null && root.val <= min.val) return false;
        if(max != null && root.val >= max.val) return false;
        return helper(root.left,min,root) && helper(root.right,root,max);
    }
}
