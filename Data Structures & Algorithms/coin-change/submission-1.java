class Solution {
    int ok(int coins[],int m,int target,int dp[][]){
        //base condition 
        //logic 
        //minimum no of coins to make up to target 
        // each coin can be used infinite times 
        if(m<0&&target!=0)return (int)1e9;
        if(target==0)return 0;
        // if(m<0&&target==0)return 0;
        

        int take=Integer.MAX_VALUE;
        int not_take=Integer.MAX_VALUE;
        if(coins[m]<=target){
            
             take=1+ok(coins,m,target-coins[m],dp);
        }
        not_take=ok(coins,m-1,target,dp);

        return Math.min(take,not_take);
    }
    public int coinChange(int[] coins, int target) {
        int m=coins.length;
        int dp[][]=new int[m][target+1];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        int ans=ok(coins,m-1,target,dp);
        return ans==1e9?-1:ans;
        
    }
}
