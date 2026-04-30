class Solution {
    public String convertToTitle(int columnNumber) {
       StringBuilder ans=new StringBuilder();
       int temp=columnNumber;
       while(temp!=0){
        temp-=1;
        int n=temp%26;
        temp=temp/26;
        ans.append((char)('A'+n));
       }
       ans.reverse();
       return ans.toString(); 
        
    }
}
//TC - O(Logn)
//SC-O(1)