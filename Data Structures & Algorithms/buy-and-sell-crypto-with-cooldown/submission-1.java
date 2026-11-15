class Solution {
    int ok(int index,int buying,int nums[],int dp[][]){
        if(index>=nums.length)return 0;
        
        if(dp[index][buying]!=-1)return dp[index][buying];
        int ans=Integer.MIN_VALUE;
        if(buying==1){
            ans= Math.max(ok(index+1,0,nums,dp)-nums[index],
            ok(index+1,1,nums,dp));
        }
        else {
            ans= Math.max(ok(index+2,1,nums,dp)+nums[index],
            ok(index+1,0,nums,dp));
        }
        dp[index][buying]= ans;
        return dp[index][buying];
    }
    public int maxProfit(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        return ok(0,1,nums,dp);

    }
}
