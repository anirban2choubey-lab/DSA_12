package leetcode.repeat;

public class DecodeWays_91 {
    public static void main(String[] args) {

    }

    public static int decodeWays(String s) {
        if (s.length()<1 || s.charAt(0)=='0') return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            int prev = s.charAt(i - 2) - '0';
            int cur = s.charAt(i - 1) - '0';
            int combo = prev * 10 + cur;
            if (prev > 0)
                dp[i] += dp[i - 1];
            if (combo >= 10 && combo <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
}
