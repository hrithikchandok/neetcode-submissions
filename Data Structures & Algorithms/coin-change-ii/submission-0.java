class Solution {
    int ok(int amount,int n,int nums[],int index,int dp[][]){
        if(index<0&&amount==0){
            return 1;
        }
                if(amount==0){
            return 1;
        }
        if(index<0){
            return 0;
        }
        if(dp[amount][index]!=-1)return dp[amount][index];

        
        int l=0,r=0;
        if(nums[index]<=amount){
            l=ok(amount-nums[index],n,nums,index,dp);
        }
        r=ok(amount,n,nums,index-1,dp);
        dp[amount][index]=l+r;
        return dp[amount][index];
    }
    public int change(int amount, int[] nums) {
        int n=nums.length;
        int dp[][]=new int[amount+1][n];
        for(int i=0;i<=amount;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return ok(amount,n,nums,n-1,dp);
    }
}
