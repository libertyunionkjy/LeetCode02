package hot100;

public class HardFindMedianSortedArrays04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        return findKthNum(nums1,0,len1 - 1,nums2,0,len2 - 1,left) * 0.5 +
                findKthNum(nums1,0,len1 - 1,nums2,0,len2 - 1,right) * 0.5;
    }
    public double findKthNum(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if(len1 > len2) return findKthNum(nums2,start2,end2,nums1,start1,end1,k);

        if(len1 == 0) return nums2[start2 + k - 1];
        if(k == 1) return Math.min(nums1[start1],nums2[start2]);

        int nums1Index = start1 + Math.min(len1,k/2) - 1;
        int nums2Index = start2 + Math.min(len2,k/2) - 1;

        if(nums1[nums1Index] < nums2[nums2Index]){
            return findKthNum(nums1, nums1Index + 1,end1,nums2,start2,end2,k - (nums1Index - start1 + 1));
        }else{
            return findKthNum(nums1,start1,end1,nums2,nums2Index + 1,end2,k - (nums2Index - start2 + 1));
        }
    }
}
