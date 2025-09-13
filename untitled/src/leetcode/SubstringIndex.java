package leetcode;

public class SubstringIndex {
    public static void main(String[] args) {
        String haystack = "icadbutsad", needle = "sad";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        for (int i = 0; i <= (haystack.length() - needle.length()); i++) {
            String temp = haystack.substring(i, i+needle.length());
            if (temp.equals(needle))
                return i;
        }
        return -1;
    }
}
