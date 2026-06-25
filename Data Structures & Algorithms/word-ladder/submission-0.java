class Solution {
    class Pair{
        String key;
        int value;
        Pair(String key,int value){
            this.key=key;
            this.value=value;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String>s1=new HashSet<>();
        for(String word:wordList){
            s1.add(word);
        }
        Queue<Pair>q1=new LinkedList<>();
        q1.add(new Pair(beginWord,1));
        while(!q1.isEmpty()){
            Pair temp=q1.poll();
            String curr=temp.key;
            int len=temp.value;
            char curr_arr[]=curr.toCharArray();
            if(curr.equals(endWord))return len;
            for(int i=0;i<curr_arr.length;i++){
                char ch=curr_arr[i];
                for(char x='a';x<='z';x++){
                    if(ch!=x){
                        curr_arr[i]=x;
                        String newWord=new String(curr_arr);
                        if(s1.contains(newWord)){
                            q1.add(new Pair(newWord,len+1));
                            s1.remove(newWord);
                        }
                    }
                }
                curr_arr[i]=ch;
            }
        }
        return 0;
    }
}
