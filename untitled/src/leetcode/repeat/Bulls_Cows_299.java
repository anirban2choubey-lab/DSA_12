package leetcode.repeat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bulls_Cows_299 {
    public static void main(String[] args) {
        // Input: secret = "11231", guess = "11171" =>3A or 2A1B
        //Output: "1A1B"
    }

    public static String getHint(String secret, String guess) {
        int[] res = new int[2];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            if (guess.charAt(i) == c)
                res[0]++;
            else
                map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < guess.length(); i++) {
            char g = guess.charAt(i);
            if (secret.charAt(i) != g && map.containsKey(g) && map.get(g) > 0) {
                res[1]++;
                map.put(g, map.get(g) - 1);
            }
        }
        return res[0] + "A" + res[1] + "B";
    }

    public static String getHint_ar(String secret, String guess) {
        int[] count = new int[10];
        int[] res = new int[2];

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i))
                res[0]++;
            else {
                count[secret.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                if (count[guess.charAt(i) - '0'] > 0)
                    count[guess.charAt(i) - '0']--;
                res[1]++;
            }
        }
        return res[0] + "A" + res[1] + "B";
    }
}
