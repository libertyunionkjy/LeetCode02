package exam.Interview0910;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3,1,6,5,2,4};
        helper(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void helper(int[] nums){
        int left = 0;
        while (left < nums.length){
            //找到第一个奇数
            while (left < nums.length && nums[left] % 2 != 1) left++;
            if(left == nums.length)
                return;
            //找到这个奇数后的第一个偶数
            int right = left + 1;
            while (right < nums.length && nums[right] % 2 == 1) right++;
            //如果一个奇数后面没有偶数了，结束返回
            if(right == nums.length)
                return;
            //把奇数和偶数交换
            swap(nums, left, right);
            left++;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
