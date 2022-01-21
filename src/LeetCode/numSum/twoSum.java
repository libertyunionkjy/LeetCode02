package LeetCode.numSum;

import java.util.Arrays;

public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] numsSorted = Arrays.copyOf(nums, nums.length);
        sort(numsSorted,0,nums.length - 1);
        int lo = 0, hi = nums.length - 1;
        while (lo < hi){
            int sum = numsSorted[lo] + numsSorted[hi];
            if(sum < target){
                lo++;
            } else if (sum > target) {
                hi--;
            } else if (sum == target) {
                break;
            }
        }
        if((numsSorted[lo] + numsSorted[hi]) == target){
            int first = 0, last = nums.length - 1;
            for (int i = 0; i < nums.length; i++) {
                if(numsSorted[lo] == nums[i]){
                    first = i;
                }
            }
            for (int i = nums.length - 1; i >= 0 ; i--) {
                if(numsSorted[hi] == nums[i]){
                    last = i;
                }
            }
            return new int[]{first, last};
        }
        return null;
    }

    public static void sort(int[] nums,int start,int end){
        if(start >= end)
            return;
        int partition = nums[start];
        int lo = start+1;
        int hi = end;
        while (lo <= hi){
            if(nums[lo] <= partition){
                lo++;
            }else{
                swap(nums,lo,hi);
                hi--;
            }
        }
        swap(nums,start,hi);
        sort(nums,start,hi - 1);
        sort(nums,lo,end);
    }

    public static void swap(int[] nums,int lo,int hi){
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,1,3,3,0,0,5,4};
        System.out.println(Arrays.toString(new twoSum().twoSum(nums,-3)));
    }
}
