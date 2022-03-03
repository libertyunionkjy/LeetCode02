package hot100;

import datastructure.TreeNode;

public class MidFlatten114 {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        flatten(root.left);
        flatten(root.right);
        if(root.left != null)
        {
            TreeNode preRight = findLast(root.left);
            preRight.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return;
    }

    TreeNode findLast(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}
