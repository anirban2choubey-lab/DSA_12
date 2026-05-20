package leetcode.repeat;

public class ClimbingStairs_dp_70 {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        int res = 0;
        if (n <= 2)
            return n;
        for (int i = 3; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
