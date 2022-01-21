package LeetCode;

import datastructure.TreeNode;

public class CountNodes222 {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode lt = root, rt = root;
        int l = 0, r = 0;
        while(lt != null){
            lt = lt.left;
            l++;
        }
        while(rt != null){
            rt = rt.right;
            r++;
        }
        if(l == r) return ((int)Math.pow(2,l) - 1);
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
