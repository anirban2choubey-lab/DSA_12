package leetcode;

public class DecodeWays_91 {
    public static void main(String[] args) {
        System.out.println(numDecodings_2("226")); // 3
        System.out.println(numDecodings_2("12"));  // 2
        System.out.println(numDecodings_2("0"));   // 0
        System.out.println(numDecodings_2("10"));  //1
    }

    public static int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        if (s.charAt(0) == '0') return 0;
        for (int i = 2; i <= s.length(); i++) {
            char prev = s.charAt(i - 2);
            char cur = s.charAt(i - 1);
            if (cur != 0)
                dp[i] += dp[i - 1];
            // if (prev != 0) {
            int dbl = (prev - '0') * 10 + (cur - '0');
            if (dbl >= 10 && dbl <= 26)
                dp[i] += dp[i - 2];
            //}
        }
        return dp[s.length()];
    }

    public static int numDecodings_2(String s) {
        int[] tab = new int[s.length() + 1];
        if (s.charAt(0) == '0') return 0;
        tab[0] = 1;
        //tab[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            char prev = s.charAt(i - 1);
            char cur = s.charAt(i);
            if (cur != '0')
                tab[i] += tab[i - 1];
            int dd = (prev - '0') * 10 + (cur - '0');
            if (10 <= dd && dd <= 26) {
                if (i - 2 < 0)
                    tab[i] += 1;
                else
                    tab[i] += tab[i - 2];
            }
        }
        return tab[s.length() - 1];
    }
}
