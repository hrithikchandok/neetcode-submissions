class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[]=new int[2];
        HashMap<Integer,Integer>s1=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(s1.containsKey(target-nums[i])){
                ans[0]=s1.get(target-nums[i]);
                ans[1]=i;
            }
            s1.put(nums[i],i);
        }
        return ans;
    }
}
