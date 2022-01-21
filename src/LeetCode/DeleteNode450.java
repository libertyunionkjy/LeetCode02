package LeetCode;

import datastructure.TreeNode;

public class DeleteNode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        return helper(root, key);
    }

    TreeNode helper(TreeNode root,int key){
        if(root == null){
            return null;
        }else if(root.val > key){
            root.left = helper(root.left,key);
        }else if(root.val < key){
            root.right = helper(root.right,key);
        }else if(root.val == key){
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = helper(root.right, minNode.val);
        }
        return root;
    }

    TreeNode findMin(TreeNode root){
        TreeNode cur = root;
        while(cur.left != null){
            cur = cur.left;
        }
        return cur;
    }
}
