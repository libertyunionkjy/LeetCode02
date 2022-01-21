package LeetCode.tree;

/**
 * @author Ke,Junyu
 * @Link https://labuladong.gitee.io/algo/1/5/
 */

import datastructure.TreeNode;
import LeetCode.SerializeAndDeSerializeForBinaryTree297;
import java.util.LinkedList;
import java.util.Queue;

public class minDepth111 {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int step = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return step;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);

                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        String str = "1,2,3,4,5";
        SerializeAndDeSerializeForBinaryTree297 util = new SerializeAndDeSerializeForBinaryTree297();
        TreeNode root = util.BFSDeserialize(str);
        System.out.println(new minDepth111().minDepth(root));
    }
}
