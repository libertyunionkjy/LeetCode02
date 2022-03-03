package hot100;

import datastructure.TreeNode;

public class MidBuildTree105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return  helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int leftPreStart = preStart + 1;
        int leftPreEnd;
        int rightPreStart;
        int rightPreEnd;
        for (int i = inStart; i <= inEnd; i++) {

        }
        // 构造左子树
        // 构造右子树
        return null;
    }
}
