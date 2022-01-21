package LeetCode;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeSerializeForBinaryTree297 {


    /**
     * 二叉树的前序遍历进行序列化和反序列化
     */
    // Encodes a tree to a single string.
    String NULL = "null";
    String SPLIT = ",";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        BFSSerialize(root, sb);
        return sb.toString();
    }

    void preorderSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SPLIT);
            return;
        }

        sb.append(root.val).append(SPLIT);
        preorderSerialize(root.left, sb);
        preorderSerialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return BFSDeserialize(data);
    }

    //my method
    TreeNode preorderDeserialize(String[] arr, int start, int end) {
        if (arr[start].equals(NULL))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[start]));
        int leftEnd = start + 1;
        int count = 1;
        do {
            if (arr[leftEnd].equals(NULL)) {
                leftEnd++;
                count--;
            } else {
                leftEnd++;
                count++;
            }
        } while (count > 0);
        root.left = preorderDeserialize(arr, start + 1, leftEnd);
        root.right = preorderDeserialize(arr, leftEnd, end);
        return root;
    }

    //labuladong method
    TreeNode preorderDeserialize(LinkedList<String> list) {
        if (list.isEmpty())
            return null;
        String s = list.removeFirst();
        if (s.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = preorderDeserialize(list);
        root.right = preorderDeserialize(list);

        return root;
    }

    /**
     * 后序遍历和前序遍历相似，中序遍历无法完成反序列化
     */
    /**
     * 看一下层序遍历的序列化和反序列化
     */


    public void BFSSerialize(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            //这里把节点值为空放在取出来后比较
            if (tmp == null) {
                sb.append(NULL).append(SPLIT);
                continue;
            }

            sb.append(tmp.val).append(SPLIT);
            queue.offer(tmp.left);
            queue.offer(tmp.right);
        }
    }

    public TreeNode BFSDeserialize(String data){
        if (data.isEmpty())
            return null;

        String[] notes = data.split(SPLIT);
        TreeNode root = new TreeNode(Integer.parseInt(notes[0]));

        //queue队列存放的是父节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < notes.length;) {
            TreeNode parent = queue.poll();
            String left = notes[i++];
            //处理左节点
            if(left.equals(NULL)){
                parent.left = null;
            }else{
                parent.left = new TreeNode(Integer.parseInt(left));
                queue.offer(parent.left);
            }
            //处理右节点
            String right = notes[i++];
            if(right.equals(NULL)){
                parent.right = null;
            }else{
                parent.right = new TreeNode(Integer.parseInt(right));
                queue.offer(parent.right);
            }
        }
        return root;
    }

}
