package LeetCode;

public class isMatch {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int i = 2; i <= m; i += 2) {
            if (p.charAt(i - 1) == '*')
                dp[0][i] = dp[0][i - 2];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = (((p.charAt(j-2) == s.charAt(i-1)) || p.charAt(j-2) == '.') && dp[i-1][j])
                            || (dp[i][j-2]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        isMatch solu = new isMatch();
        String s = "aaa";
        String p = "ab*a*c*";
        System.out.print(solu.isMatch(s, p));
    }
}
