class Solution {
    private void dfs(int i,int prev, int visited[], List<List<Integer>> adj) {
        visited[i] = 1;
        for (int neg : adj.get(i)) {
            if(visited[neg]==0)
            dfs(neg,prev,visited,adj);
        }
    }
    public int countComponents(int n, int[][] nums) {
        int compo = 0;
        List<List<Integer>> adj = new ArrayList<>();
        int visited[] = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < nums.length; i++) {
            adj.get(nums[i][0]).add(nums[i][1]);
            adj.get(nums[i][1]).add(nums[i][0]);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0){
                compo++;
                dfs(i,-1,visited,adj);
            }
        }
        return compo;
    }
}
