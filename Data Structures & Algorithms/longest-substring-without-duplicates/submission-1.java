class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>s1=new HashMap<>();
        int ans=0;
        int r=0;
        int l=0;
        char ch[]=s.toCharArray();
         while(r<ch.length){
            if(s1.containsKey(ch[r])){
                l=Math.max(l,s1.get(ch[r])+1);
            }
            s1.put(ch[r],r);
            ans=Math.max(ans,r-l+1);
            r++;    
        }
        return ans;
    }
}
