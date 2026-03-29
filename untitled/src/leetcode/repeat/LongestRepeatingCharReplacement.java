package leetcode.repeat;

public class LongestRepeatingCharReplacement {
    public static void main(String[] args) {

    }

    public int characterReplacement(String s, int k) {
        int[] ar = new int[26];
        int maxFreq = 0, l = 0, maxWindow = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ar[c - 'A']++;
            maxFreq = Math.max(maxFreq, ar[c - 'A']);
            while (l < i && i - l + 1 - maxFreq > k) {

                ar[s.charAt(l) - 'A']--;
                l++;
            }
            maxWindow = Math.max(i - l + 1, maxWindow);
        }
        return maxWindow;
    }
}
