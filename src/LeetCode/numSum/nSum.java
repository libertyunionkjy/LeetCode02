package LeetCode.numSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ke,junyu
 */
public class nSum {
    public static List<List<Integer>> nSum(int[] nums,int n,int target){
        sort(nums,0,nums.length - 1);
        return nSum(nums, n, 0, target);
    }

    public static List<List<Integer>> nSum(int[] nums,int n,int start,int target){
        List<List<Integer>> res = new ArrayList<>();
        if(n < 2 || nums.length < n) return res;
        if (n == 2) {
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
        }else{
            for (int i = start; i < nums.length - (n - 1); i++) {
                List<List<Integer>> iReses = nSum(nums,n - 1, i + 1,target - nums[i]);
                for (List<Integer> iRes : iReses){
                    iRes.add(nums[i]);
                    res.add(iRes);
                }
                while (i < nums.length - (n - 1) && nums[i + 1] == nums[i]) i++;
            }
        }
        return res;
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
//        int[] nums = {-1, -2, -3, 1, 3, 3, 0, 0, 5, 4,-1,-4};
        int[] nums = {0,0,0};
        System.out.println(nSum(nums,2,0));
    }
}
