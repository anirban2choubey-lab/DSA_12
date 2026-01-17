package leetcode.repeat;

public class Distinct_subsequence_115 {
    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        numDistinct(s, t);
    }

    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        //if the s is empty we cannot form t so return 0;
        if (t.isEmpty()) return 0;
        int[][] dp = new int[m + 1][n + 1];
        //if t is empty only 1 way we can form t by not using any character from s
        //so for every character space we will fill 0
        for (int i = 0; i <= m; i++)
            dp[i][0] = 1;

        // we will iterate over the 2d Array to check if both characters from s & t are matching
        //if not matching we will take the result till previous character from t -- dp[i][j]= dp[i][j-1]
        //
        // OPTION A: Don't use sChar.
        // We need to find the entire current t-prefix in the previous part of s.
        // Value comes from the cell directly above (dp[i-1][j]).
        //
        // OPTION B: Use sChar.
        // We match sChar with tChar. Now we need to find the *rest* of t
        // (t[0...j-2]) in the previous part of s.
        // Value comes from diagonal up-left (dp[i-1][j-1]).


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sChar = s.charAt(i-1);
                char tChar = t.charAt(j-1);
                int skipChar = dp[i-1][j];
                int matchCHar = dp[i - 1][j - 1];
                if (sChar == tChar)
                    dp[i][j] = skipChar + matchCHar;
                else
                    dp[i][j] = skipChar;
            }
        }
        return dp[m][n];
    }
}
