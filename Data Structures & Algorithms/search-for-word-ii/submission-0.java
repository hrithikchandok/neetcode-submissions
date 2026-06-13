class Solution {
    TrieNode root;
    class TrieNode{
        String endWord;
        boolean isEnd;
        HashMap<Character,TrieNode>children;
        TrieNode(){
            endWord=null;
            isEnd=false;
            children=new HashMap<>();
        }
    }
    void add(String word){
        TrieNode curr=root;
        for(char ch:word.toCharArray()){
            curr.children.putIfAbsent(ch,new TrieNode());
            curr=curr.children.get(ch);
        }
        curr.endWord=word;
        curr.isEnd=true;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String>ans=new ArrayList<>();
        root=new TrieNode();
        // add all in the trie
        for(String temp:words){
            add(temp);
        }
        int r=board.length;
        int c=board[0].length;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                dfs(board,i,j,root,ans);
            }
        }
        return ans;
    }
    private void dfs(char [][]board,int r,int c,TrieNode node,List<String>ans){
        if(r<0||c<0||r>=board.length||c>=board[0].length||board[r][c]=='#'){
            return ;
        }
        char ch=board[r][c];
        if(!node.children.containsKey(ch)){
            return;
        }
        TrieNode nextNode=node.children.get(ch);
        if(nextNode.isEnd){
            ans.add(nextNode.endWord);
            nextNode.isEnd=false;
            
        }

        board[r][c]='#';
        
        // move four direction 
        dfs(board,r+1,c,nextNode,ans);
        dfs(board,r-1,c,nextNode,ans);
        dfs(board,r,c+1,nextNode,ans);
        dfs(board,r,c-1,nextNode,ans);
        board[r][c]=ch;

    }
}
