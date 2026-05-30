class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int h = numbers.length - 1;
        
        while (l < h) {
            int sum = numbers[l] + numbers[h];
            
            if (sum == target) {
                // Return 1-based indices
                return new int[]{l + 1, h + 1};
            } else if (sum > target) {
                h--;
            } else {
                l++;
            }
        }
        
        // Default return if no solution is found (though the problem guarantees one)
        return new int[]{};
    }
}