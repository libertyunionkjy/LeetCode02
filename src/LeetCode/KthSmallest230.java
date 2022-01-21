package LeetCode;

import datastructure.TreeNode;

import java.util.ArrayList;

public class KthSmallest230 {
    ArrayList<Integer> output = new ArrayList<>();
    int i = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root,k);
        return res;
    }
    //my method
    void helper(TreeNode root){
        if(root == null)
            return;
        helper(root.left);
        output.add(root.val);
        helper(root.right);
        return;
    }
    //labuladong method
    int rank = 0;
    int res;
    void traverse(TreeNode root,int k){
        if(root == null)
            return;
        traverse(root.left,k);
        rank++;
        if(rank == k){
            res = root.val;
            return;
        }
        traverse(root.right,k);
    }
    public static void main(String[] args) {
        KthSmallest230 so = new KthSmallest230();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.print(so.kthSmallest(root,1));
    }
}
