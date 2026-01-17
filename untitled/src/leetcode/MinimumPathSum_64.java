package leetcode;

public class MinimumPathSum_64 {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 3, 1}};
        System.out.print(minPathSum(grid1));
    }

    public static int minPathSum(int[][] grid) {
        int cl = grid.length;
        int rl = grid[0].length;
        int[][] dp = new int[cl + 1][rl + 1];
        dp[0][0] = grid[0][0];
        //for first row
        for (int j = 1; j < rl; j++)
            dp[0][j] = dp[0][j - 1]+grid[0][j];
        //for first column
        for (int i = 1; i < cl; i++)
            dp[i][0] += dp[i - 1][0]+grid[i][0];

        for (int i = 1; i < cl; i++) {
            for (int j = 1; j < rl; j++)
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
        }
        return dp[cl-1][rl-1];
    }
}
