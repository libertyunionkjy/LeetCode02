package LeetCode.numSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//找出不重复的三元组
public class threeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums, 0,0);
    }

    public static List<List<Integer>> threeSum(int[] nums, int start, int target) {
        sort(nums, 0, nums.length - 1);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = start; i < nums.length - 2; i++) {
            List<List<Integer>> iReses = twoSum(nums, i + 1,target - nums[i]);
//            System.out.println(nums[i]);
//            System.out.println(iReses.toString());
            for (List<Integer> iRes :
                    iReses) {
                iRes.add(nums[i]);
                res.add(iRes);
            }
            int left = nums[i];
            while (i < nums.length - 1 && nums[i + 1] == left) i++;
        }
        return res;
    }

    public static List<List<Integer>> twoSum(int[] nums, int start,int target) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo];
            int right = nums[hi];
            if (sum < target) {
                lo++;
                while (lo < hi && nums[lo] == left) lo++;
            } else if (sum > target) {
                hi--;
                while (lo < hi && nums[hi] == right) hi--;
            } else if (sum == target) {
                res.add(new ArrayList<>(Arrays.asList(nums[lo], nums[hi])));
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            }
        }
        return res;
    }

    public static void sort(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int partition = nums[start];
        int lo = start + 1;
        int hi = end;
        while (lo <= hi) {
            if (nums[lo] <= partition) {
                lo++;
            } else {
                swap(nums, lo, hi);
                hi--;
            }
        }
        swap(nums, start, hi);
        sort(nums, start, hi - 1);
        sort(nums, lo, end);
    }

    public static void swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, -2, -3, 1, 3, 3, 0, 0, 5, 4,-1,-4};
        int[] nums = {0,0,0};
        System.out.println(threeSum(nums,0,0).toString());
    }
}
