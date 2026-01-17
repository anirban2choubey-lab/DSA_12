package leetcode.repeat;

import java.util.Arrays;

public class Coin_change_322 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 1;
        for (int i = 1; i < amount; i++) {
            if (dp[i]>amount) continue;
            //if ()
            for (int c : coins) {
               //avoiding  if (i + c <= amount) to handle very large numbers of integer
                // where adding this 2 numbers may end up surpassing the integer limit
                if (i <= amount - c)
                    dp[i + c] = Math.min(dp[i + c], dp[i] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
