package leetcode.repeat;

public class Climbing_stairs {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        int a = 1, b = 2;
        int res = 0;
        if (n < 3)
            return n;
        for (int i = 3; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
