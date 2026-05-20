package leetcode;

import java.util.*;

public class FruitPicker_904 {
    public static void main(String[] args) {

    }

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0, maxFruit = 0;

        while (r < fruits.length) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0)
                    map.remove(fruits[l]);
                l++;
            }
            maxFruit = Math.max(maxFruit, r - l + 1);
            r++;
        }
return maxFruit;
    }
}
