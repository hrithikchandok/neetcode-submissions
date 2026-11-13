class Solution {
    
    int ok(int i,int j,int m,int n,int dp[][]){
        if(i>m||j>n||i<0||j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(i==0&&j==0){
            return 1;
        }
        dp[i][j]= ok(i-1,j,m,n,dp)+ok(i,j-1,m,n,dp);
        return dp[i][j];
       

    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
       return ok(m-1,n-1,m,n,dp);
    }
}
