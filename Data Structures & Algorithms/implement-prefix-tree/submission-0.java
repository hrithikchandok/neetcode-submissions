public class TrieNode{
    HashMap<Character,TrieNode>children=new HashMap<>();
    boolean endword;
    TrieNode(){
        children=new HashMap<>();
        endword=false;
    }
}
class PrefixTree {
    TrieNode root;
    public PrefixTree() {
         root=new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr=root;
        for(char ch:word.toCharArray()){
            curr.children.putIfAbsent(ch,new TrieNode());
            curr=curr.children.get(ch);
        }
        curr.endword=true;
    }

    public boolean search(String word) {
        TrieNode curr=root;
        for(char ch:word.toCharArray()){
            if(curr.children.containsKey(ch)){
                curr=curr.children.get(ch);
            }
            else return false;
        }
        return curr.endword==true;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(char ch:prefix.toCharArray()){
            if(curr.children.containsKey(ch))
            curr=curr.children.get(ch);
            else{
                return false;
            }
        }
        return true;
    }
}
