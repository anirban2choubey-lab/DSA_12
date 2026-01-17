package leetcode.repeat;

public class Interleaving_string {
    public static void main(String[] args) {
        String S1 = "aabcc", S2 = "dbbca", S3 = "aadbbcbcac";
        System.out.println(isInterleave(S1, S2, S3));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (n + m != s3.length())
            return false;
        int lis1 = -1;
        int lis2 = -1;
        for (int i = 0; i < s3.length(); i++) {
            char c = s3.charAt(i);
            int s1i = s1.indexOf(c, lis1+1);
            int s2i = s2.indexOf(c, lis2+1);

            if (s1i >= 0 && lis1 + s1i < m)
                lis1 += s1i;
            else if (s2i >= 0 && lis2 + s2i < n) {
                lis2 += s2i;
            } else
                return false;
        }
        return true;
    }
}
