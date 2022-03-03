package hot100;

import datastructure.TreeNode;

public class EasyInvertTree226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }
}
