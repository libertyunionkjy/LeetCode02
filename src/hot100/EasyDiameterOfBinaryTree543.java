package hot100;

import datastructure.TreeNode;

public class EasyDiameterOfBinaryTree543 {
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int myDiameter = left + right;
        maxDiameter = Math.max(myDiameter, maxDiameter);
        return 1 + Math.max(left,right);
    }
}
