class Solution {
    // [1,3,4,2,2]
    //  0 1 2 3 4
    // [3,1,3,4,2]
    //  0 1 2 3 4

    public int findDuplicate(int[] nums) {
        for(int ele:nums){
            int index=Math.abs(ele)-1;
            if(nums[index]<0)return Math.abs(ele);
            nums[index]*=-1;
        }
        return -1;
    }
}
