package leetcode;

public class LongestRepeatingCharacterReplacement_424 {
    public static void main(String[] args) {
        System.out.println("result--" + characterReplacement("AABABBA", 1));
    }

    //best explanation :: https://www.youtube.com/watch?v=ExY8svHF_Eo
    public static int characterReplacement(String s, int k) {
        int maxWindow = 0;
        //to put occurance of character in array
        int[] freq = new int[26];
        int maxFreq = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            freq[c - 'A']++;
            //checking which character has maximum occurance
            maxFreq = Math.max(freq[c - 'A'], maxFreq);
            //normally increasing window size but if replacement required to keep every character same is more than k
            // then removing the  element from left & increasing left 1 place
            // or we can use while loop also to check & remove every left element
            if (r - l + 1 - maxFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            } else
                maxWindow = Math.max(r - l + 1, maxWindow);
        }
        return maxWindow;
    }
}
