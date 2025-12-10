package leetcode;

public class ClimbingStores {

    public static void main(String[] args) {
        int n = 9;
        System.out.print(climbStairs(n));
    }

    public static int climbStairs(int n) {
        int[] tab = new int[n + 1];
        tab[0] = 1;
        tab[1] = 2;
        for (int i = 2; i < n; i++) {
            tab[i] = tab[i - 2] + tab[i - 1];
        }
        return tab[n-1];
    }

    //without tabulation
    public static int climbStairs_wo_tab(int n) {
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
