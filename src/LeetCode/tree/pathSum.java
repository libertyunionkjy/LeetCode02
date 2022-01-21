package LeetCode.tree;

import datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class pathSum {
    //1：每次构造ArrayList，效率较低
    public List<List<Integer>> pathSum01(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, res, path, sum);
        return res;
    }

    private void helper(TreeNode root, List<List<Integer>> res, List<Integer> path, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                res.add(path);
            }
        }
        //注意这里必须要new一个ArrayList向下传递，不然会影响全局path
        helper(root.left, res, new ArrayList<>(path), sum - root.val);
        helper(root.right, res, new ArrayList<>(path), sum - root.val);
    }

    //2：使用回溯
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(res,path,root,sum);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> path, TreeNode root, int sum) {
        if(root == null)
            return;

        path.addLast(root.val);
        sum -= root.val;

        if(sum == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
        }

        dfs(res, path, root.left, sum);
        dfs(res, path, root.right, sum);

        path.removeLast();
    }
}
