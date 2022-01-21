package offer;

public class longestPalindrome {
    String solution01_dp(String s) {
        //边界条件判断
        int length = s.length();
        if (length < 2)
            return s;
        char[] sArray = s.toCharArray();
        int maxlength = 1;
        int start = 0;
        //初始化动态规划数组
        int[][] dp = new int[length][length];
        for (int i = 0; i <= length - 1; i++) {
            dp[i][i] = 1;
            if (i + 1 < length) {
                if (sArray[i] == sArray[i + 1]) {
                    dp[i][i + 1] = 2;
                    maxlength = 2;
                    start = i;
                } else {
                    dp[i][i + 1] = 0;
                }
            }
        }
        //填数组
        for (int j = 2; j < length; j++) {
            for (int i = 0; i < j - 1; i++) {
                if (sArray[i] == sArray[j] && dp[i + 1][j - 1] != 0) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    int len = j - i + 1;
                    if (len > maxlength) {
                        maxlength = len;
                        start = i;
                    }
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return s.substring(start,start + maxlength);
    }
}
