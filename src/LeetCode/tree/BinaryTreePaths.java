package LeetCode.tree;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePaths {
    //分治
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<>();
        if (root == null)
            return path;

        List<String> leftPath = binaryTreePaths(root.left);
        List<String> rightPath = binaryTreePaths(root.right);

        //在左右子树的每一条路径上加上根节点，叶子节点不会进入for循环
        for (String node : leftPath) {
            path.add(root.val + "->" + node);
        }
        for (String node : rightPath) {
            path.add(root.val + "->" + node);
        }

        //处理叶子结点
        if (path.size() == 0) {
            path.add(Integer.toString(root.val));
        }

        return path;
    }
    //DFS方法
    public List<String> DFS(TreeNode root) {
        List<String> paths = new ArrayList<>();
        helper(root, "", paths);
        return paths;
    }

    private void helper(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer tmp = new StringBuffer(path);
            tmp.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {
                paths.add(tmp.toString());
            } else {
                tmp.append("->");
                helper(root.left,tmp.toString(),paths);
                helper(root.right,tmp.toString(),paths);
            }
        }
    }

    //广度优先
    public List<String> BFS(TreeNode root){
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<String> queuePaths = new LinkedList<>();
        List<String> res = new ArrayList<>();

        queueNode.add(root);
        queuePaths.add(Integer.toString(root.val));

        while( !queueNode.isEmpty() ){
            TreeNode pNode = queueNode.remove();
            String path = queuePaths.remove();
            if(pNode.left == null && pNode.right == null){
                res.add(path);
            }
            if(pNode.left != null){
                queuePaths.add(path + "->" + pNode.left.val);
                queueNode.add(pNode.left);
            }
            if(pNode.right != null){
                queuePaths.add(path + "->" + pNode.right.val);
                queueNode.add(pNode.right);
            }
        }
        return res;
    }
}
