package leetcode;

public class Interleaving_string_97 {
    public static void main(String[] args) {
       System.out.println( isInterleave("aabcc","dbbca","aadbbcbcac"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        // boolean res = false;
        int li1 = -1;
        int li2 = -1;
        for (int i = 0; i < s3.length(); i++) {
            char c = s3.charAt(i);
            //if (s1.substring(li1) < li1)
            int ti1 = s1.indexOf(c, li1);
            int ti2 = s2.indexOf(c, li2);
            if ((ti1 <= 0 && ti2 <= 0) || (li1>=s1.length()-1 && li2>=s2.length()-1))
                return false;
            if (ti1 >= 0 && ti2 >= 0) {
                if (li1<= s1.length()-1 )
                    li1 += ti1;
                else
                    li2 += ti2;
            }
            if (ti1 > 0 && ti2 <= 0) {
                li1 += ti1;

            }
            if (ti1 <= 0 && ti2 > 0) {
                li2 += ti2;

            }
        }
        if (li1 == s1.length() - 1 && li2 == s2.length() - 1)
            return true;
        else
            return false;
    }
}
