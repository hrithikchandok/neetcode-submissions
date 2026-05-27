class Solution {

    public String encode(List<String> strs) {
        StringBuilder temp=new StringBuilder();
        for(String curr:strs){
            temp.append(curr.length());
            temp.append('#'); // it will fail for double length
            temp.append(curr);
        }
        return temp.toString();
    }


    public List<String> decode(String str) {
        List<String >ans=new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#')j++;
            int len=Integer.parseInt(str.substring(i,j));
            String temp=str.substring(j+1,j+len+1);
            ans.add(temp);
            i=j+len+1;
        }
        return ans;
    }
}
