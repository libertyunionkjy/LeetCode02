package exam;

public class IsMatch {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;

        s = "0" + s;
        p = "0" + p;

        for (int i = 2; i <= pLen; i += 2) {
            if (p.charAt(i) == '*')
                dp[0][i] = dp[0][i - 2];
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if(match(s,p,i,j))
                    dp[i][j] = dp[i - 1][j - 1];
                else if(p.charAt(j) == '*'){
                    if(match(s,p,i,j - 1)){
                        dp[i][j] =  dp[i - 1][j] ||
                                    dp[i][j - 1] ||
                                    dp[i][j - 2];
                    }else{
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }

        return dp[sLen][pLen];
    }

    boolean match(String s, String p, int i, int j)
    {
        if(p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))
            return true;
        return false;
    }
}
