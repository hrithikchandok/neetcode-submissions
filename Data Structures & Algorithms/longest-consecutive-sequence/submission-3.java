class Solution {
    public int longestConsecutive(int[] nums) {
        // range based answer 
        HashMap<Integer,Integer>mp=new HashMap<>();
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            if (mp.containsKey(nums[i])) continue;
            int left=mp.getOrDefault(nums[i]-1, 0);
            int right=mp.getOrDefault(nums[i]+1, 0);
            int currentLen = left+right+1;
            mp.put(nums[i], currentLen);
            ans=Math.max(ans, currentLen);
            mp.put(nums[i]-left, currentLen);
            mp.put(nums[i]+right, currentLen);
            // mp[nums[i]+right]=Math.max(mp[nums[i]+right],mp[nums[i]]);
        }
        return ans;
    }
}
