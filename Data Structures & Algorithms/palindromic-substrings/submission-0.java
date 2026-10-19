class Solution {
    int ok(int left,int right,String s){
        int res=0;
        while(left>=0&&right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            res++;
        }
        return res;
    }
    public int countSubstrings(String s) {
        int n=s.length();
        int res=0;
        for(int i=0;i<n;i++){
            res+=ok(i,i,s);
            res+=ok(i,i+1,s);
        }
        return res;
    }
}
