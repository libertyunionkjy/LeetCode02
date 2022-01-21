package LeetCode;

import datastructure.TreeNode;

public class ConstructMaximumBinaryTree654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length);
    }

    TreeNode helper(int[] nums, int start, int end) {
        if (start >= end)
            return null;
        int maxIndex = findMaxNum(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = helper(nums,start,maxIndex);
        root.right = helper(nums,maxIndex + 1,end);
        return root;
    }

    int findMaxNum(int[] nums, int start, int end) {
        int res = start;
        for (int i = start; i < end; i++) {
            res = nums[i] > nums[res] ? i : res;
        }
        return res;
    }
}
