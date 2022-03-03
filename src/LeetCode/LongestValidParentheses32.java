package LeetCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LongestValidParentheses32 {
    public boolean isValidParentheses(String s){
        if(s == null || s.length() == 0) return true;
        Deque<Integer> stack = new LinkedList<Integer>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(-1);
            }else if(stack.isEmpty()) {
                return false;
            }else{
                stack.pop();
            }
        }
        if(stack.isEmpty())
            return true;

        return false;
    }
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        int maxLength = 0;

        int len = s.length();
        if(len == 1)
            return 0;

        int[] dp = new int[len + 1];

        dp[0] = dp[1] = 0;

        for (int i = 2; i <= len; i++) {
            if(s.charAt(i - 1) == ')'){
                if (s.charAt( i - 2) == '('){
                    dp[i] = dp[i - 2] + 2;
                    maxLength = dp[i] > maxLength ? dp[i] : maxLength;
                }else if(i - 2 - dp[i - 1] < 0){
                    dp[i] = 0;
                } else if (s.charAt(i - 2 - dp[i - 1]) == '('){
                    dp[i] = dp[i - 1] + 2 + dp[i - (dp[i - 1] + 2)];
                    maxLength = dp[i] > maxLength ? dp[i] : maxLength;
                }else
                    dp[i] = 0;
            }else
                dp[i] = 0;
        }
        return maxLength;
    }
}
