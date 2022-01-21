package LeetCode.numSum;

import LeetCode.numSum.nSum;

import java.util.List;

public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return nSum.nSum(nums,4,target);
    }
}
