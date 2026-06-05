class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int temp1[]=new int[26];
        int temp2[]=new int[26];
        if(s1.length()>s2.length())return false;
        for(int i=0;i<s1.length();i++)
        {
            temp1[s1.charAt(i)-'a']++;
            temp2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(temp1,temp2)){
            return true;
        }
        for(int i=s1.length();i<s2.length();i++){
            temp2[s2.charAt(i-s1.length())-'a']--;
            temp2[s2.charAt(i)-'a']++;
            if(Arrays.equals(temp1,temp2))return true;
        }
        return false;
    }
}
