package LeetCode;

import datastructure.TreeNode;

public class ConvertBST538 {
    //right root val
    TreeNode last;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    void  helper(TreeNode root){
        if(root == null)
            return;
        helper(root.right);
        if(last != null){
            root.val = last.val + root.val;
        }
        last = root;
        helper(root.left);
    }

//    public static void main(String[] args) {
//        SerializeAndDeSerializeForBinaryTree297 seri = new SerializeAndDeSerializeForBinaryTree297();
//        String s = "4,1,6,0,2,5,7,#,#,#,3,#,#,#,8,";
//        TreeNode root = seri.deserialize()
//    }
}
