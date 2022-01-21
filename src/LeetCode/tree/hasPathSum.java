package LeetCode.tree;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class hasPathSum {
    //BFS
    public boolean hasPathSumBFS(TreeNode root, int targetSum) {
        if(root == null)
            return false;

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> intQueue = new LinkedList<>();

        queue.add(root);
        intQueue.add(root.val);

        while(!queue.isEmpty()){
            TreeNode pNode = queue.remove();
            int sum = intQueue.remove();
            if(pNode.left == null && pNode.right == null){
                if(sum == targetSum)
                    return true;
            }
            if(pNode.left != null){
                queue.add(pNode.left);
                intQueue.add(sum+ pNode.left.val);
            }
            if(pNode.right != null){
                queue.add(pNode.right);
                intQueue.add(sum+ pNode.right.val);
            }
        }
        return false;
    }

    //DFS
    public boolean hasPathSum(TreeNode root, int targetSum){
        if(root == null)
            return false;

        if(root.left == null && root.right == null)
            return root.val == targetSum ? true : false;

        boolean leftRes = hasPathSum(root.left,targetSum - root.val);
        boolean rightRes = hasPathSum(root.right, targetSum - root.val);
        return leftRes || rightRes;
    }
}
