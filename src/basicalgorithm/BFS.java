package basicalgorithm;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void BFS(TreeNode tree) {
        if(tree == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);

        while(!queue.isEmpty()){
            TreeNode pNode = queue.remove();
            System.out.print(pNode.val + ", ");

            if(pNode.left != null)
                queue.add(pNode.left);
            if(pNode.right != null)
                queue.add(pNode.right);
        }
    }
}
