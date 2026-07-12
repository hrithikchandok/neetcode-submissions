class Solution {
    int ok(int index,int nums[],int dp[]){
        if(index<0)return 0;
        if(index==0)return nums[0];
        if(dp[index]!=-1)return dp[index];
        int take=nums[index]+ok(index-2,nums,dp);
        int not_take=ok(index-1,nums,dp);
        dp[index]=Math.max(take,not_take);
        return dp[index];
    }
    public int rob(int[] nums) {
        int ans;
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return ok(n-1,nums,dp);
    }
}
