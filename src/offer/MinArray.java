package offer;

public class MinArray {
    /**
     * @author Junyu Ke
     * @create date: 27-11-2020
     * @param nums
     * @return
     */
    public int minArray(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int left = 0, right = nums.length - 1;
        if(nums[right] > nums[0])
            return nums[0];
          while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            else if(nums[mid - 1] > nums[mid])
                return nums[mid];
            else if(nums[mid] > nums[0])
                left = mid + 1;
            else if(nums[mid] < nums[0])
                right = mid - 1;
        }
        return -1;
    }
}
