class Solution {
    public int minEatingSpeed(int[] nums, int h) {
    int low = 1;
    // Fix: Find the maximum value in the array to set the upper bound
    int high = 0;
    for (int num : nums) {
        if (num > high) {
            high = num;
        }
    }
    
    int ans = high;
    while (low <= high) {
        // Use mid calculation that prevents overflow
        int mid = low + (high - low) / 2;
        
        if (canEat(mid, h, nums)) {
            ans = mid;
            high = mid - 1; // Try for a slower speed (smaller K)
        } else {
            low = mid + 1;  // Too slow, need faster speed
        }
    }
    return ans;
}

private boolean canEat(int k, int h, int[] nums) {
    long hoursNeeded = 0;
    for (int ele : nums) {
        // Correct ceiling division:
        hoursNeeded += (ele + k - 1) / k;
    }
    return hoursNeeded <= h;
}
}
