package hot100;

public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        // 凑 0 只需要0个硬币
        if (amount == 0) {
            return 0;
        }

        int len = coins.length;
        int[] dp = new int[amount + 1];

        // 对于已经有的硬币，要凑这部分的数额只需要一个硬币
        for (int i = 0; i < len; i++) {
            if (coins[i] > amount) {
                continue;
            }
            dp[coins[i]] = 1;
        }

        // 在最小的硬币面值之前，无法凑成这部分的面额数值
        int i = 1;
        while (i <= amount && dp[i] != 1) {
            dp[i] = -1;
            i++;
        }

        // 开始求最值，i 此时要么已经出界，要么在最小值上
        for (int j = i + 1; j <= amount; j++) {
            if(dp[j] == 1)
                continue;
            int tmp = Integer.MAX_VALUE;
            for (int k = 0; k < len; k++) {
                if (j - coins[k] < 0 || dp[j - coins[k]] == -1) {
                    continue;
                }
                tmp = dp[j - coins[k]] + 1 < tmp ? dp[j - coins[k]] + 1 : tmp;
            }
            if (tmp == Integer.MAX_VALUE) {
                dp[j] = -1;
                continue;
            }
            dp[j] = tmp;
        }

        return dp[amount];
    }
}
