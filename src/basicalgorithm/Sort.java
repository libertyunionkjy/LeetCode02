package basicalgorithm;

public class Sort {
    public void quickSort(int[] nums,int left,int right){
        if(left >= right)
            return;
        int low = left + 1, high = right;
        while(low <= high){
            if(nums[low] <= nums[left]){
                low++;
            }else{
                swap(nums,low,high);
                high--;
            }
        }
        swap(nums,left,high);
        quickSort(nums,left,high-1);
        quickSort(nums,low,right);
    }

    public void swap(int[] nums, int low, int high){
        int tmp = nums[low];
        nums[low] = nums[high];
        nums[high] = tmp;
    }
}
