package offer;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        dfs(root,target,res,track,0);
        return res;
    }

    void dfs(TreeNode root,int target, List<List<Integer>> res, List<Integer> track,int sum){
        // 1.如果到了叶子结点，而且路径和符合要求，就加入到结果集中
        if(root.left == null && root.right == null && root.val + sum == target) {
            track.add(root.val);
            List<Integer> tmp = new ArrayList<>(track);
            res.add(tmp);
            track.remove(track.size() - 1);
            return;
        }else if(root.left == null && root.right == null){
            // 如果到了叶子结点，而且路径和不符合要求，那么直接返回
            return;
        }
        // 如果没有到叶子结点，就把当前结点加入到路径中，并且和要更新
        track.add(root.val);
        sum += root.val;
        if(root.left != null){
            dfs(root.left,target,res,track,sum);
        }
        if (root.right != null) {
            dfs(root.right,target,res,track,sum);
        }
        // 移除当前节点，回溯
        track.remove(track.size() - 1);
        return;
    }
}
