class Solution {
    int ok(int index,int target,int nums[],int dp[][]){
        if(index<0){
            return target==0?1:0;
        }
        if(dp[index][target+1000]!=-1)return dp[index][target+1000];
        int l=ok(index-1,target+nums[index],nums,dp);
        int r=ok(index-1,target-nums[index],nums,dp);
        return dp[index][target+1000]=l+r;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int offset=1000;
        int n=nums.length;
        int dp[][]=new int[n][2001];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        return ok(n-1,target,nums,dp);
    }
}
