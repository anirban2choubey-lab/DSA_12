package leetcode.repeat;

import java.util.Arrays;

public class CoinChangeDP_322 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("number of coins --"+coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (coins.length == 1) {
            return coins[0] == amount ? 1 : -1;
        }
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i > 0 && dp[i] > amount)
                    continue;
                if (i + coin <= amount)
                    dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
