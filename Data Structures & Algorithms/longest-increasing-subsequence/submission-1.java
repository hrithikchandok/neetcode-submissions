class Solution {
    int ok(int index,int prev_index,int nums[],int dp[][]){
        if(index==nums.length)return 0;
        if(dp[index][prev_index+1]!=-1)return dp[index][prev_index+1];
        int take=0,not_take=0;
                if(prev_index==-1||nums[index]>nums[prev_index]){
            take=1+ok(index+1,index,nums,dp);
        }
        not_take=ok(index+1,prev_index,nums,dp);
        dp[index][prev_index+1]= Math.max(take,not_take);
        return dp[index][prev_index+1];
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n+1];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return ok(0,-1,nums,dp);
    }
}
