package leetcode;

public class Distinct_subsequence_115 {
    public static void main(String[] args) {
      String  s = "rabbbit", t = "rabbit";
      numDistinct(s,t);
    }

    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i=0;i<=m;i++)
            dp[i][0]=1;
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == s.charAt(j - 1))
                    dp[i][j] += dp[i - 1][j - 1];


            }
        }
        return dp[m][n];

    }
}
