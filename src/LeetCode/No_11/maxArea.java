package LeetCode.No_11;

public class maxArea {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = Math.min(height[left], height[right]) * (right - left);
        while (left < right) {
            if (height[left] < height[right]) {
                int i = left;
                while (left < right && height[left] <= height[i]){
                    left++;
                }
                int temp = Math.min(height[left], height[right]) * (right - left);
                res = temp > res ? temp : res;
            } else {
                int i = right;
                while (left < right && height[right] <= height[i]){
                    right--;
                }
                int temp = Math.min(height[left], height[right]) * (right - left);
                res = temp > res ? temp : res;
            }
        }
        return res;
    }
}
