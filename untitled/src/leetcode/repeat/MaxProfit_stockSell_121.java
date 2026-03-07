package leetcode.repeat;

public class MaxProfit_stockSell_121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("max return--" + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int max_return = 0;
        for (int i = 1; i < prices.length; i++) {
            max_return = Math.max(max_return, prices[i] - min);
            min = Math.min(prices[i], min);
        }
        return max_return;
    }
}
