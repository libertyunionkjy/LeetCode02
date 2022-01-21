package LeetCode;

import datastructure.TreeNode;

public class InsertIntoBST701 {

    //my method
    public TreeNode insertIntoBSTMy(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode(val);
            return root;
        }
        if(root.val > val && root.left == null){
            root.left = new TreeNode(val);
        }else if(root.val < val && root.right == null){
            root.right = new TreeNode(val);
        }else if(root.val > val){
            insertIntoBST(root.left,val);
        }else if(root.val < val){
            insertIntoBST(root.right,val);
        }
        return root;
    }

    //labuladong method
    TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空位置插入新节点
        if (root == null) return new TreeNode(val);
        // if (root.val == val)
        //     BST 中一般不会插入已存在元素
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        return root;
    }
}
