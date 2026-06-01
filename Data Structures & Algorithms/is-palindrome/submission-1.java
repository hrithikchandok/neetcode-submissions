class Solution {
    boolean isAlphabet(char ch){
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')|| (ch>='0'&& ch<='9'))return true;
        return false;
    }
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        String s1=s.toLowerCase();
        while(i<j){
            char ch1=s1.charAt(i);
            char ch2=s1.charAt(j);
            if(isAlphabet(ch1)&&isAlphabet(ch2)&& ch1!=ch2){
                return false;
            }
            else if(isAlphabet(ch1)&&isAlphabet(ch2)&& ch1==ch2){
                i++;
                j--;
            }
            else{
                if(!isAlphabet(ch1))
                    i++;
                if(!isAlphabet(ch2))
                   j--;    
            }
        }
        return true;
    }
}
