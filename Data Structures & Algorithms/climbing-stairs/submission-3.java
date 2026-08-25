class Solution {
    public int climbStairs(int n) {
        // int dp[]=new int[n+1];
        // Arrays.fill(dp,0);
        // dp[0]=1;
        // dp[1]=1;
        int f=1;
        int s=1;
        for(int i=2;i<=n;i++){
            // dp[i]=dp[i-1]+dp[i-2];
            int t=f+s;
            f=s;
            s=t;
        }
        // return dp[n];
        return s;
        // space optimisation of this question 

    }
}
