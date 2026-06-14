class Solution {
    private boolean dfs(int i,int prev,int visited[],List<List<Integer>>adj){
        visited[i]=1;
        boolean ans=true;
        for(int neg:adj.get(i)){
            if(visited[neg]==1 && prev==neg)continue;
            if(visited[neg]==1&& prev!=neg)return false;
            ans=ans&& dfs(neg,i,visited,adj);
        }
        return ans;
    }
    public boolean validTree(int n, int[][] nums) {
        List<List<Integer>>adj=new ArrayList<>();
        int visited[]=new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<nums.length;i++){
          
            adj.get(nums[i][0]).add(nums[i][1]);
            adj.get(nums[i][1]).add(nums[i][0]);
        }
        // detec the cycle if there is a cycle or not 
         if(!dfs(0,-1,visited,adj))return false;
         for(int i=0;i<n;i++){
            if(visited[i]==0)return false;
         }
         return true;
    }
}
