package exam.Interview0911;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.lchild = new TreeNode(1);
        root.lchild.lchild = new TreeNode(0);
        root.rchild = new TreeNode(3);
        helper(root);
    }

    public static void helper(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;

        while(!stack.isEmpty() || cur!=null){
            //  一直往左走，把所有左子节点入栈
            while (cur != null){
                stack.push(cur);
                cur = cur.lchild;
            }
            //走到最左边了，拿出一个访问，然后入栈右节点
            if(!stack.isEmpty()){
                cur = stack.pop();
                System.out.println(cur.val);
                cur = cur.rchild;
            }

        }
    }

}

class TreeNode{
    int val;
    TreeNode lchild;
    TreeNode rchild;
    TreeNode(int val){
        this.val = val;
    }
}
