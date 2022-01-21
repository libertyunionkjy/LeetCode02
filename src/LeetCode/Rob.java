package LeetCode;

import java.util.Arrays;

public class Rob {

    class Solution {
        public int rob_circle(int[] nums) {
            if(nums.length == 0)
                return 0;
            else if(nums.length == 1)
                return nums[0];
            int[] nums1 = Arrays.copyOfRange(nums,0,nums.length-1);
            int[] nums2 = Arrays.copyOfRange(nums,1,nums.length);
            return Math.max(rob_noCircle(nums1), rob_noCircle(nums2));
        }

        int rob_noCircle(int[] nums){
            if(nums.length == 0)
                return 0;
            else if(nums.length == 1)
                return nums[0];

            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0],nums[1]);
            for (int i = 2; i < dp.length; i++) {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
            return dp[dp.length - 1];
        }

    }
}
