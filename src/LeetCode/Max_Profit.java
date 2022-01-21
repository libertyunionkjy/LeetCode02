package LeetCode;

public class Max_Profit {
    public int maxProfit(int[] prices,int fee) {
        if(prices.length < 2)
            return 0;
        return maxProfit_infinityK_fee(fee, prices);
    }

    /**
     *
     * @param prices
     * @return
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     */
    int maxProfit_once(int[] prices){
        int day = prices.length;
        int dp_i_0=0;
        int dp_i_1=-prices[0];
        for (int i = 1; i < day; i++) {
            dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1=Math.max(dp_i_1,-prices[i]);
        }
        return dp_i_0;
    }

    /**
     *
     * @param prices
     * @return
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     */
    int maxProfit_infinityK(int[] prices){
        int day = prices.length;
        int i_0 = 0;
        int i_1 = -prices[0];
        for (int i = 1; i < day; i++) {
            i_0 = Math.max(i_0,i_1+prices[i]);
            i_1 = Math.max(i_1,i_0-prices[i]);
        }
        return i_0;
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
     */
    public int maxProfit_2K(int[] prices){
        int day = prices.length;
        int i_1_0 = 0, i_1_1 = -prices[0];
        int i_2_0 = 0, i_2_1 = -prices[0];
        for (int i = 1; i < day; i++) {
            i_1_0 = Math.max(i_1_0,i_1_1 + prices[i]);
            i_1_1 = Math.max(i_1_1,-prices[i]);
            i_2_0 = Math.max(i_2_0,i_2_1 + prices[i]);
            i_2_1 = Math.max(i_2_1,i_1_0 - prices[i]);
        }
        return i_2_0;
    }

    /**
     *https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
     */
    public int maxProfit_k(int k, int[] prices) {
        if(prices.length < 2)
            return 0;
        int day = prices.length;
        //k大于等于交易天数的1/2时，k相当于是没有限制的
        if(k >= day/2)
            return maxProfit_infinityK(prices);
        int[][][] dp = new int[day][k + 1][2];
        for (int i = 0; i < day; i++) {
            for (int j = 1; j <= k; j++) {
                if (i - 1 == -1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                }else{
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i-1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i-1][j-1][0] - prices[i]);
                }
            }
        }
        return dp[day - 1][k][0];
    }
    /**
     *
     * @param prices
     * @return
     * dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1] + price[i])
     * dp[i][1]=Math.max(dp[i-1][1],dp[i-2][0] - price[i])
     */
    int maxProfit_infinityK_cool(int[] prices){
        int day = prices.length;
        int i_0 = 0;
        int i_1 = -prices[0];
        int i_pre_0 = 0;
        for (int i = 1; i < day; i++) {
            int tmp = i_0;
            i_0 = Math.max(i_0,i_1 + prices[i]);
            i_1 = Math.max(i_1,i_pre_0 - prices[i]);
            i_pre_0 = tmp;
        }
        return i_0;
    }
    int maxProfit_infinityK_fee(int fee, int[] prices){
        int day = prices.length;
        int i_0 = 0;
        int i_1 = -prices[0] - fee;
        for (int i = 1; i < day; i++) {
            int tmp = i_0;
            i_0 = Math.max(i_0,i_1 + prices[i]);
            i_1 = Math.max(i_1,tmp - prices[i] - fee);
        }
        return i_0;
    }
}
