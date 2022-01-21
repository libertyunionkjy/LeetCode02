package offer;

class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                } else {
                    int tmp = nums[i];
                    nums[i] = nums[nums[i]];
                    nums[tmp] = tmp;
                }
            }
        }
        return -1;
    }
}
