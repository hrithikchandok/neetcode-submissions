class UnionFind{
    int rank[];
    int parent[];
    UnionFind(int n){
        rank=new int[n+1];
        parent=new int[n+1];
        for(int i=0;i<=n;i++){
            rank[i]=1;
            parent[i]=i;
        }
    }
    int find(int x){
        if(x!=parent[x])
          parent[x]=find(parent[x]);
        return parent[x];
    }
    boolean union(int x,int y){
        //
        int par=find(x);
        int par2=find(y);

        if(par==par2){
            return false;
        }
        if(rank[par]>rank[par2]){
            parent[par2]=par;
        }
        else if(rank[par2]>rank[par]){
            parent[par]=par2;
        }
        else{
            parent[par2]=par;
            rank[par]++;
        }
        return true;
    }
}
class Solution {
    
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        UnionFind uf=new UnionFind(n);
        for(int edge[]:edges){
            boolean res=uf.union(edge[0],edge[1]);
            if(!res){
                return edge;
            }
        }
        return new int[0];
    }
}
