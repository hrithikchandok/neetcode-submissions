class Solution {
    public String minWindow(String s, String t) {
        int res[]={-1,-1};
        // int need=t.length();
        int have=0;
        int l=0;
        int right=0;
        int ans=Integer.MAX_VALUE;
        HashMap<Character,Integer>countT=new HashMap<>();
        HashMap<Character,Integer>countS=new HashMap<>();
        for(int i=0;i<t.length();i++){
            countT.put(t.charAt(i),countT.getOrDefault(t.charAt(i),0)+1);
        }
        int need=countT.size();
        while(right<s.length()){
            char ch=s.charAt(right);
            countS.put(ch,countS.getOrDefault(ch,0)+1);
            if(countT.containsKey(ch)&& countT.get(ch)==countS.get(ch)){
                have++;
            }
            // shrink logic to get the minimum 
            while(have==need){
               if (right - l + 1 < ans) {
                    ans = right - l + 1;
                    res[0] = l;
                    res[1] = right;
                }
                char ch1=s.charAt(l);
                l++;
                countS.put(ch1,countS.get(ch1)-1);
                if(countT.containsKey(ch1)&& countT.get(ch1)-1==countS.get(ch1))
                have--;
            }
            right++;
        }
        return ans==Integer.MAX_VALUE?"":s.substring(res[0],res[1]+1);
    }
}
