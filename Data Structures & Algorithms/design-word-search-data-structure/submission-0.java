class TrieNode{
    HashMap<Character,TrieNode> children;
    boolean endWord;
    TrieNode(){
        children=new HashMap<>();
        endWord=false;
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr=root;
        for(char ch:word.toCharArray()){
            curr.children.putIfAbsent(ch,new TrieNode());
            curr=curr.children.get(ch);
        }
        curr.endWord=true;
    }

    public boolean search(String word) {
        TrieNode curr=root;
        return searchHelper(word,0,curr);
    }
    public boolean searchHelper(String temp,int index,TrieNode curr){
        for(int i=index;i<temp.length();i++){
            char ch=temp.charAt(i);
            if(ch=='.'){
                for(TrieNode child:curr.children.values()){
                    if(searchHelper(temp,i+1,child)){
                        return true;
                    }
                }
                return false;
            }
            else{
                if(!curr.children.containsKey(ch))return false;
                curr=curr.children.get(ch);
            }
        }
        return curr.endWord;
    }
}
