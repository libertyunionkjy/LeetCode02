package hot100;

import LeetCode.SerializeAndDeSerializeForBinaryTree297;
import datastructure.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MidLowestCommonAncestor236Test {

    @Test
    void lowestCommonAncestor() {
        SerializeAndDeSerializeForBinaryTree297 util = new SerializeAndDeSerializeForBinaryTree297();
        String nums = "1,2,3,null,4";
        TreeNode root = util.deserialize(nums);
        MidLowestCommonAncestor236 test = new MidLowestCommonAncestor236();
        TreeNode p = root.left.right;
        TreeNode q = root.right;
        System.out.println(p.val);
        System.out.println(q.val);
        System.out.println(test.lowestCommonAncestor(root,p,q).val);
    }
}