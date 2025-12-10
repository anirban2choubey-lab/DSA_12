package leetcode;

public class HouseRobber_198 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.print(rob(nums));
    }
//without tabulation
    public static int rob(int[] nums) {
        int[] tab = new int[nums.length + 1];
        int a = 0;
        int b = nums[0];
        int c;
        for (int i = 1; i < nums.length; i++) {
            //comparing [last -1] +current & [last]
            c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }
    //with tabulation
    public static int rob_tab(int[] nums) {
        int [] tab = new int[nums.length+1];
        tab[0]=0;
        tab[1]=nums[0];
        for (int i=2;i<= nums.length;i++)
            tab[i]= Math.max(tab[i-1],tab[i-2]+nums[i-1]);
        return tab[nums.length];
    }
}
