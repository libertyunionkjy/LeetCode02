package offer;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 * 编辑距离
 * 72
 * hard
 */

/**
 * 1.dp[i][j]=?
 * 1.1  word1[i]==word2[j]  dp[i-1][j-1]
 * 1.2  !=?   选取以下三种操作+1后最小的
 * a)最后一步是插入  dp[i][j-1]
 * word1[0...i]-->word2[0...j-1]
 * 插入word2[j]
 * b)最后一步是删除  dp[i-1][j]
 * word1[0...i-1]-->word2[0...j](注意此时word1[i]还在）
 * 删除word1[i]
 * c)最后一步是替换  dp[i-1][j-1]
 * word1[0...i-1]-->word2[0...j-1]
 * 替换word1[i]==word2[j]
 * 2.初始化：其中一个为0，等于另一个字符串的长度
 * dp[0][x]=x
 * dp[x][0]=x
 * 3.时间复杂度，MN，MN分别为两个字符串的长度
 */
public class minDistance {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        minDistance solution = new minDistance();
        System.out.println(solution.minDisatance(word1, word2));
    }

    public int minDisatance(String word1, String word2) {
        int n = word1.length(), m = word2.length();

        if (n == 0 || m == 0)
            return n == 0 ? m : n;

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] =1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];
    }
}
