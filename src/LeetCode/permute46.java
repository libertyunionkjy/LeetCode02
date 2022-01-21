package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class permute46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        backtrack(nums, res,new LinkedList<>());
        return res;
    }

    public static void backtrack(int[] nums,List<List<Integer>> res, LinkedList<Integer> trace){
        if (trace.size() == nums.length) {
            List<Integer> newRes = new LinkedList<>(trace);
            res.add(newRes);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(trace.contains(nums[i])){
                continue;
            }
            trace.addLast(nums[i]);
            backtrack(nums,res, trace);
            trace.removeLast();
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new permute46().permute(nums));
    }
}
