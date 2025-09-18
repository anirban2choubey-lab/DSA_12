package leetcode;

public class StringtoInteger_atoi_8 {
    public static void main(String[] args) {
        System.out.println("res::" + myAtoi("  +0 123"));
    }

    public static int myAtoi(String s) {
        long res = 0;
        s = s.trim();
        char sign=s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 && sign == '-') || (i == 0 && sign == '+') || (s.charAt(i) == ' '))
                continue;
            if (!Character.isDigit(s.charAt(i)))
                break;
            else {
                int t = s.charAt(i) - '0';
                if (res > Integer.MAX_VALUE / 10 - t)
                    return sign == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                res = res * 10 + t;
            }

        }
        if (sign == '-')
            res = 0 - res;
        return (int) res;
    }
}
