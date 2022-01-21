package basicalgorithm;

import datastructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class DFS {

    public static void preorderDFS(TreeNode tree) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = tree;

        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                System.out.print(pNode.val + ", ");
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                pNode = stack.pop();
                pNode = pNode.right;
            }
        }
    }

    public static void preorderDFS_bk(TreeNode tree) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(tree);

        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            System.out.println(tmp.val);

            if (tmp.right != null)
                stack.push(tmp.right);
            if (tmp.left != null)
                stack.push(tmp.left);
        }
    }

    public static void inorderDFS(TreeNode tree) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = tree;

        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                pNode = stack.pop();
                System.out.print(pNode.val + ", ");
                pNode = pNode.right;
            }
        }
    }

    public static void postorderDFS(TreeNode tree) {
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<TreeNode> ostack = new LinkedList<>();
        TreeNode pNode = tree;

        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                ostack.push(pNode);//根节点最后出栈，最先入栈
                pNode = pNode.right;//右节点倒数第二出栈，后于根节点入栈
            } else {
                pNode = stack.pop();//根节点和右节点都没有了，再进左节点
                pNode = pNode.left;
            }
        }

        while (!ostack.isEmpty()) {
            System.out.print(ostack.pop().val + ", ");
        }
    }

    //递归
    public static void preOrderDFS(TreeNode tree){
        if(tree == null){
            return;
        }
        System.out.print(tree.val + ", ");
        preOrderDFS(tree.left);
        preOrderDFS(tree.right);
    }
}
