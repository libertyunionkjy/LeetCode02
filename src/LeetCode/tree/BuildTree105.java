package LeetCode.tree;

import datastructure.TreeNode;

import java.util.HashMap;

public class BuildTree105 {
    HashMap<Integer,Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i],i);
        }
        return build(preorder,inorder,0,preorder.length,0,inorder.length);
    }

    TreeNode build(int[] preorder, int[] inorder, int preorderstart, int preorderEnd, int inorderStart, int inorderend){
        if(preorderstart >= preorderEnd)
            return null;
        int inorderIndex = inorderMap.get(preorder[preorderstart]);
        TreeNode root = new TreeNode(preorder[preorderstart]);
        int leftChildNum = inorderIndex - inorderStart;
        int rightChildNum = inorderend - inorderIndex;
        root.left = build(preorder,inorder,preorderstart + 1, preorderstart + leftChildNum + 1,inorderStart,inorderIndex);
        System.out.println();
        root.right = build(preorder,inorder,preorderstart + leftChildNum + 1,preorderEnd,inorderIndex + 1,inorderend);
        return root;
    }
}
