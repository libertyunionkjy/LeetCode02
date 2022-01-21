package LeetCode;

import datastructure.TreeNode;

import java.util.*;

public class FindDuplicateSubtrees652 {
    HashMap<String,Integer> map = new HashMap<>();
    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        travel(root);
        return res;
    }


    //以一个结点为根的二叉树序列化，并看这个结点需不需要加入结果集
    String travel(TreeNode root){
        if(root == null)
            return "#";
        String left = travel(root.left);
        String right = travel(root.right);
        //序列化时不能是中序，#0#0#实际上有两种子树的形态
        String subtree = left + "," + right + "," + root.val ;

        int freq = map.getOrDefault(subtree,0);
        if(freq == 1){
            res.add(root);
        }
        map.put(subtree,freq + 1);
        return subtree;
    }
}
