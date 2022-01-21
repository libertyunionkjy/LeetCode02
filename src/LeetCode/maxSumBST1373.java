package LeetCode;

import datastructure.TreeNode;
import LeetCode.SerializeAndDeSerializeForBinaryTree297;

/**
 * 1.left tree and right tree is a BST?
 * 1.1  isBST()
 * 2.if left tree and right tree is BST, then root tree is a BST?
 * 2.1   Max()
 * 2.2   Min()
 * <p>
 * 3.if root tree is a BST,count the node val sum
 * 3.1   countSum()
 */

public class maxSumBST1373 {
    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[]{1, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        /**
         * [isBST,max,min,sum]
         */
        int[] res = new int[4];
        if (left[0] == 1 && right[0] == 1 && root.val > left[1] && root.val < right[2]) {
            res[0] = 1;
            res[1] = Math.max(right[1], root.val);
            res[2] = Math.min(left[2], root.val);
            res[3] = left[3] + right[3] + root.val;
            maxSum = Math.max(maxSum, res[3]);
        } else {
            res[0] = 0;
        }
        return res;
    }


    int max(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int childMax = Math.max(max(root.left), max(root.right));
        return Math.max(root.val, childMax);
    }

    int min(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int childMin = Math.min(min(root.left), min(root.right));
        return Math.min(root.val, childMin);
    }

    int countSum(TreeNode root) {
        if (root == null)
            return 0;
        return countSum(root.left) + countSum(root.right) + root.val;
    }

    boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isBST(root.left)) return false;
        if (!isBST(root.right)) return false;

        int leftMax = max(root.left);
        int rightMin = min(root.right);
        if (root.val < leftMax || root.val > rightMin)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int a = 10, b = 11;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + ", " + b);
    }
}
