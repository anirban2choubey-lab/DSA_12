package leetcode.repeat;

public class CoinChange518 {
    public static void main(String[] args) {

    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                dp[i] += dp[i - c];
            }

        }

        return dp[amount];
    }
}
