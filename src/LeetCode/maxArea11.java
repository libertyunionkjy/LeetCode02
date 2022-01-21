package LeetCode;

public class maxArea11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length;
        int minSide = height[left] > height[right] ? right : left;
        int res = (right - left) * height[minSide];
        while(left < right){
            if(height[left] <= height[right]){
                minSide = left;
                while(height[left] <= height[minSide] && left < right){
                    left++;
                }
                minSide = height[left] > height[right] ? right : left;
                res = (right - left) * height[minSide] > res ? (right - left) * height[minSide] : res;
            }else{
                minSide = right;
                while(height[right] <= height[minSide] && left < right){
                    right--;
                }
                minSide = height[left] > height[right] ? right : left;
                res = (right - left) * height[minSide] > res ? (right - left) * height[minSide] : res;
            }
        }
        return res;
    }
}
