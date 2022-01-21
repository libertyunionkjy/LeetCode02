package hot100;

/**
 * @Link:https://leetcode-cn.com/problems/reverse-integer/
 * 主要在于溢出的判断，注意这里是整数除法，不能直接移项得到不等式
 */

class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x != 0){
            int num = x % 10;
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > 7)) return 0;
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && num < -8)) return 0;
            res = res * 10 + num;
            x /= 10;
        }
            return res;
    }
}

public class Reverse_7 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int x = -321;
        System.out.println(s.reverse(x));
    }
}
