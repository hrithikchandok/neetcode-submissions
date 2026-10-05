class Solution {
    public String longestPalindrome(String s) {
        // String ans=0;
        int n=s.length();
        int dp[][]=new int[n][n];
        
        // 01234
        String ans="";
        int maxlen=0;
        for(int diff=0;diff<=n-1;diff++){
            for(int i=0;i<n;i++){
                int j=i+diff;
                if(j>=n)continue;
                if(diff==0){
                    dp[i][j]=1;
                }
                else if(j-i+1==2){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=1;
                    }
                }
                else{
                    if(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]==1){
                        dp[i][j]=1;
                    }
                }
                if(dp[i][j]==1&&j-i+1>maxlen){
                    maxlen=j-i+1;
                    ans=s.substring(i,j+1);
                }
            }
        }
        return ans;

    }
}
