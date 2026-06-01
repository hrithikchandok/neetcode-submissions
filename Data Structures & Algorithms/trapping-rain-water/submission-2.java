public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;
        
        while (l < r) {
            if (leftMax < rightMax) {
                // 1. Calculate first (Will safely add 0 at the very edges)
                res += leftMax - height[l];
                // 2. Move the pointer
                l++;
                // 3. Update the max for the next iteration
                leftMax = Math.max(leftMax, height[l]);
            } else {
                // 1. Calculate first
                res += rightMax - height[r];
                // 2. Move the pointer
                r--;
                // 3. Update the max for the next iteration
                rightMax = Math.max(rightMax, height[r]);
            }
        }
        return res;
    }
}