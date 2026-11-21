class Solution {
    int ok(int m,int n,String s1,String s2,int dp[][]){
        //base condition 
        if(m<0&&n<0)return 0;
        else if(m<0)return n+1;
        else if(n<0)return m+1;
        if(dp[m][n]!=-1)return dp[m][n];
        if(m==0&&n==0){
            if(s1.charAt(m)==s2.charAt(n))return 0;
            else 
            return 1;
        }
        //logic 
        //3 options insert a character , delete a character , replace a character 
        char ch1=s1.charAt(m);
        char ch2=s2.charAt(n);

        if(ch1==ch2){
            dp[m][n]= ok(m-1,n-1,s1,s2,dp);
        }else {
            dp[m][n]= 1+Math.min(
                ok(m-1,n,s1,s2,dp),
                Math.min(ok(m-1,n-1,s1,s2,dp),ok(m,n-1,s1,s2,dp))
                );
        }
        return dp[m][n];
    }
    public int minDistance(String s1, String s2) {
        int dp[][]=new int[s1.length()][s2.length()];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return ok(s1.length()-1,s2.length()-1,s1,s2,dp);
    }
}
