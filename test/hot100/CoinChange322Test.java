package hot100;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChange322Test {

    @Test
    void test() {
        CoinChange322 solution = new CoinChange322();
        int[] coins = {1, 2, 5};
        int amout = 1;
        System.out.println(solution.coinChange(coins, amout));
    }

}