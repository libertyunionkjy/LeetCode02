package LeetCode;

public class FindMedianSortedArrays {

    //归并思想，时间复杂度O(n+m)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0;
        int n = nums1.length, m = nums2.length, length = n + m, mid = length / 2;
        int i = 0;
        int n1 = 0, n2 = 0;
        while (p1 < nums1.length && p2 < nums2.length && i <= mid) {
            if (nums1[p1] <= nums2[p2]) {
                n2 = n1;
                n1 = nums1[p1];
                p1++;
            } else {
                n2 = n1;
                n1 = nums2[p2];
                p2++;
            }
            i++;
        }
        while (p1 < nums1.length && i <= mid) {
            n2 = n1;
            n1 = nums1[p1];
            p1++;
            i++;
        }
        while (p2 < nums2.length && i <= mid) {
            n2 = n1;
            n1 = nums2[p2];
            p2++;
            i++;
        }
        if (length % 2 == 0)
            return (n1 + n2) / 2.0;
        else
            return n1;
    }

    //二分查找递归，时间复杂度O(log(n+m))
    public double findMedianSortedArrayBinarySearch(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        //trick:奇数偶数的情况怎么写到一块去？假设n+m=5，传入的k应该是3，假设n+m=6，传入的k应该是3和4，如果是奇数，则巧妙的传入了两个相同的数
        //但是这样会增加空间使用，语言简洁但是不实用
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        return (helper(nums1, 0, n - 1, nums2, 0, m - 1, left) +
                helper(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int helper(int[] nums1, int nums1Left, int nums1Right, int[] nums2, int nums2Left, int nums2Right, int k) {
        if (nums1Left > nums1Right)
            return nums2[k - 1];
        else if (nums2Left > nums2Right)
            return nums1[k - 1];
        if (k == 1)
            return Math.min(nums1[nums1Left], nums2[nums2Left]);

        int length1 = nums1Right - nums1Left + 1;
        int length2 = nums2Right - nums2Left + 1;
        int p1 = nums1Left + Math.min(length1, k / 2) - 1;
        int p2 = nums2Left + Math.min(length2, k / 2) - 1;

        int res = 0;
        if (nums1[p1] < nums2[p2]) {
            int newk = k - (p1 - nums1Left + 1);
            res = helper(nums1, p1 + 1, nums1Right, nums2, nums2Left, nums2Right, newk);
        } else {
            int newk = k - (p2 - nums2Left + 1);
            res = helper(nums1, nums1Left, nums1Right, nums2, p2 + 1, nums2Right, newk);
        }
        return res;
    }

    public static void main(String[] args) {
//        FindMedianSortedArrays solu = new FindMedianSortedArrays();
//        int[] nums1 = {0,2,4,6,8,9};
//        int[] nums2 = {};
        String a = "abc";
        
        System.out.print(a.charAt(1));
    }
}
