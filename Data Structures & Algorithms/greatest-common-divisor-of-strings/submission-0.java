class Solution {
    public boolean isDivisor(int l,int l1,int l2,String st1,String st2){
        if(l1%l!=0||l2%l!=0)return false;
        String temp=st1.substring(0,l);
        return temp.repeat(l1/l).equals(st1)&&temp.repeat(l2/l).equals(st2);
    }
    public String gcdOfStrings(String str1, String str2) {
        int l1=str1.length();
        int l2=str2.length();
        for(int l=Math.min(l1,l2);l>0;l--){
            if(isDivisor(l,l1,l2,str1,str2))
                return str1.substring(0,l);
        }
        return "";
    }
}