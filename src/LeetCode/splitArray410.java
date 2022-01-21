package LeetCode;

public class splitArray410 {
    public int splitArray(int[] nums, int m) {
        int[] maxSum = getMaxSum(nums);
        int loMax = maxSum[0], hiMax = maxSum[1];
        while(loMax <= hiMax){
            int midMax = loMax + (hiMax - loMax) / 2;
            if(maxToM(nums,midMax) < m){
                hiMax = midMax - 1;
            }else if(maxToM(nums,midMax) > m){
                loMax = midMax + 1;
            }else if(maxToM(nums,midMax) == m){
                hiMax = midMax - 1;
            }
        }
        return loMax;
    }

    int[] getMaxSum(int[] nums){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            max = nums[i] > max ? nums[i] : max;
            sum += nums[i];
        }
        return new int[]{max,sum};
    }
    //已知max，算出最少需要分多少组
    //传进来的max值越大，分组的数就会越少
    //如果最后返回的值比m小，说明传进来的max值有可能大了，这是一个宽松条件，我把最大值的限制值调大了，这种情况下，我可以把无关紧要的小数组多分一点，最后是有可能到m的，此时可以尝试缩小max值再试一试
    //反之，如果传进来的max值小了，说明最大值限制死了，此时需要更细地切分数组，返回的值会比m更大，并且也没有什么办法让这个值减小，此时我们需要减小传入的max值
    int maxToM(int[] nums,int max){
        int m = 1;//at least one
        int subSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(subSum + nums[i] <= max){
                subSum += nums[i];
            }else{
                subSum = nums[i];
                m++;
            }
        }
        return m;
    }
}
