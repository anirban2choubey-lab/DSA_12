package leetcode;

import java.util.Arrays;

public class Minimum_requiredCoin_322 {
    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 11;
        System.out.print("coin required ::" + coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] tab = new int[amount + 1];
        Arrays.fill(tab, amount + 1);
        tab[0] = 0;
        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                tab[i] = Math.min(tab[i], tab[i - c] + 1);
            }
        }
        return tab[amount] == amount + 1 ? -1 : tab[amount];
    }
}
