class Solution {
    public int maxArea(int[] nums) {
        int l=0;
        int h=nums.length-1;
        int maxi=Integer.MIN_VALUE;
        // 1,7,2,5,4,7,3,6
        // 0 1 2 3 4 5 6 7
        while(l<=h){
            int mid=l+(h-l)/2; // to handle overflow 
            maxi=Math.max(maxi,(h-l)*Math.min(nums[h],nums[l]));
            if(nums[h]>=nums[l])l++;
            else h--;
        }   
        return maxi;
    }
}
