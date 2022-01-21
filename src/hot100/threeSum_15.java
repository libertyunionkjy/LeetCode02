package hot100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import offer.TwoSum;

/**
 * @Link:https://leetcode-cn.com/problems/3sum/ 主要难点在去重
 * 排序 + 双指针
 * 1.排序
 * k指针在最左边，i初始在k的右侧，j初始在数组最右侧
 * 2.如果nums[k]>0,跳过
 * 3.如果k>0且nums[k]=nums[k-1]，跳过，因为已经算过了
 * 4.如果s > 0，移动j指针（记得去重）
 * 5.如果s < 0,移动i指针（记得去重）
 * 6.如果s = 0,记录下来，并且移动i和j指针（记得去重）
 */
class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int s = nums[k] + nums[i] + nums[j];
                if(s < 0){
                    //if里面可以写成while(i<j && nums[i] == nums[++i])
                    i++;
                    //这两个while循环可以删掉，但是不删掉效率更高
                    while(i < j && nums[i] == nums[i - 1])//这里为什么要用i - 1？想想{-6,2,3,3,3,4}这个数组，用i+1就会跳过-6,3,3这个答案
                        i++;
                }
                else if(s > 0){
                    j--;
                    while(i < j && nums[j] == nums[j + 1])
                        --j;
                }else{
                    /**
                     * 这里的用法可以参考这个链接：https://blog.csdn.net/w574951402/article/details/53246777
                     */
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    ++i;
                    --j;
                    while(i < j && nums[i] == nums[i - 1])
                        ++i;
                    while(i < j && nums[j] == nums[j + 1])
                        --j;
                }
            }
        }
        return res;
    }
}

public class threeSum_15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-6,2,3,3,3,4};
        threeSum solution = new threeSum();
        System.out.println(Arrays.toString(solution.threeSum(nums).toArray()));
    }
}
