class Solution {
    public int ok(int i,int j,String text1,String text2,int dp[][]){
        if(i<0||j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        char ch1=text1.charAt(i);
        char ch2=text2.charAt(j);
        if(ch1==ch2){
            dp[i][j]= 1+ok(i-1,j-1,text1,text2,dp);
        }
        else{
            dp[i][j]= Math.max(ok(i-1,j,text1,text2,dp),ok(i,j-1,text1,text2,dp));
        }
        return dp[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();

        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return ok(text1.length()-1,text2.length()-1,text1,text2,dp);
    }
}
