package leetcode;

public class EditDistance_72 {
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        System.out.print(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++)
            dp[i][0] = i;
        for (int i = 0; i < n; i++)
            dp[0][i] = i;

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        return dp[m][n];
    }
//not working
    public static int minDistance_space_optimised(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] prev = new int[m + 1];

        for (int i = 0; i < m; i++)
            prev[i] = i;

        for (int i = 1; i < m; i++) {
            int[] cur = new int[m + 1];
            for (int j = i; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    cur[j] = prev[i];
                else
                    cur[j] = Math.min(prev[i], cur[j - 1]);
            }
            int[] temp = prev;
            prev=cur;
            cur=temp;
        }
return prev[m];
    }
}
