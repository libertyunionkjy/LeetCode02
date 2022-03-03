package hot100;

public class MidLongestPalindrome5 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return null;

        int start = 0;
        int maxLen = 1;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        for(int i = len - 1; i >= 0; i--){
            for(int j = i + 1; j < len; j++){
                if((j == i + 1) && s.charAt(j) == s.charAt(i)){
                    dp[i][j] = true;
                    if(maxLen < 2){
                        maxLen = 2;
                        start = i;
                    }
                    continue;
                }else if(j == i + 1){
                    continue;
                }
                if(s.charAt(j) == s.charAt(i)){
                    if(dp[i+1][j - 1]){
                        dp[i][j] = true;
                        if(j - i + 1 > maxLen){
                            maxLen = j - i + 1;
                            start = i;
                        }
                        continue;
                    }
                }
            }
        }

        return s.substring(start,start + maxLen);
    }

    public static void main(String[] args) {
        System.out.println("hello,world");
    }
}
