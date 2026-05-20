package leetcode;

import java.util.Arrays;

public class KokoEatingBanana {
    public static void main(String[] args) {
        int [] piles = {30,11,23,4,20};
        int h=6;
        System.out.println(minEatingSpeed(piles,h));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int end = Arrays.stream(piles).max().getAsInt();
        int start = 1;
        if (h == piles.length - 1)
            return end;

        while (end >= start) {
            int mid = (end + start) / 2;
            if (canFinish(piles,h,mid))
                end=mid-1;
            else
                start=mid+1;
        }
        return start;
    }

   static boolean canFinish(int[] piles, int h, int k) {
        int count = 0;
        for (int el : piles) {
            count += el / k;
            if (el % k != 0)
                count++;
        }
        return count <= h;
    }
}
