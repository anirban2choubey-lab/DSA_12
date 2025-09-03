package leetcode;

public class Container_With_Most_Water_11 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    //use two-pointers.
    // Set one pointer to the left and one to the right of the array.
    // Always move the pointer that points to the lower line.
    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1, res = 0;

        while (l < r) {
            int minHeight = Math.min(height[l], height[r]);
            int area = minHeight * (r - l);
            res = Math.max(area, res);
            if (height[l] > height[r])
                r--;
            else
                l++;

        }
        return res;

    }
}
