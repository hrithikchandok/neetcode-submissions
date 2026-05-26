class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer>s1=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(s1.contains(nums[i]))return true;
            s1.add(nums[i]);
        }
        return false;
    }
}