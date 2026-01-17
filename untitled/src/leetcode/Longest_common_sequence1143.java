package leetcode;

public class Longest_common_sequence1143 {
    public static void main(String[] args) {
        System.out.print(longestCommonSubsequence("abc", "abc"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int l = text1.length();
        int m = text2.length();
        int[][] dp = new int[l + 1][m + 1];
        if (text1.equals(text2))
            return text1.length();

        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i) == text2.charAt(j))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[l][m];
    }

    public static int longestCommonSubsequence_space_optimized(String text1, String text2) {
        int[] col = new int[text1.length()];
        int count = 0;
        for (int i = 0; i <= text1.length(); i++) {
            int[] row = new int[text2.length()];
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) ;
                count++;
            }
        }
        return 0;
    }
}
