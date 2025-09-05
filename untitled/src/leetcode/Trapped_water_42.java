package leetcode;

public class Trapped_water_42 {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }
//if the height of the current bar is less than that of a maximum bar we can store water,
// but have to remember there should be a big bar at the opposite side as well then only we can trap that water
// like if we are iterating from left there should be a big pillar present at the right side as well so that we can trap the water,
// that's why we should iterate from the small side, to get the minimum boundary &
// we should keep on checking the difference between  maximum pillar size & that pillar side


    public static int trap(int[] height) {
        int l = 0, r = height.length - 1, lMax = 0, rMax = 0, res = 0;

        while (l < r) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);
            if (lMax < rMax) {
                res += lMax - height[l];
                l++;
            } else {
                res += rMax - height[r];
                r--;
            }
        }
        return res;
    }
    //detailed approach
    public int trap2(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }
}

