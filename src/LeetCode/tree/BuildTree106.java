package LeetCode.tree;

import datastructure.TreeNode;

import java.util.HashMap;

public class BuildTree106 {
    HashMap<Integer,Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder,int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i],i);
        }
        return build(postorder,inorder,0,postorder.length,0,inorder.length);
    }

    TreeNode build(int[] postorder, int[] inorder, int postorderstart, int postorderEnd, int inorderStart, int inorderend){
        if(postorderstart >= postorderEnd)
            return null;
        int inorderIndex = inorderMap.get(postorder[postorderEnd - 1]);
        TreeNode root = new TreeNode(postorder[postorderEnd]);
        int leftChildNum = inorderIndex - inorderStart;
        int rightChildNum = inorderend - inorderIndex;
        root.left = build(postorder,inorder,postorderstart, postorderstart + leftChildNum,inorderStart,inorderIndex);
        root.right = build(postorder,inorder,postorderstart + leftChildNum,postorderEnd - 1,inorderIndex + 1,inorderend);
        return root;
    }
}
