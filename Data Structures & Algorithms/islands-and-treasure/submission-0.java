class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int count=0;
        Queue<int[]>q1=new LinkedList<>();
        int visited[][]=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==0){
                    q1.add(new int[]{i,j,-1});
                }
            }
        }
        
        while(q1.size()>0)
        {
            int []curr=q1.poll();
            int i1=curr[0];
            int j1=curr[1];
            int prev=curr[2];
            if(i1<0||j1<0||i1>=r||j1>=c||grid[i1][j1]==-1||visited[i1][j1]==1)continue;
            visited[i1][j1]=1;
            //move all the direction mark the one as -1
            grid[i1][j1]=Math.min(grid[i1][j1],prev+1);
            q1.add(new int[]{i1+1,j1,grid[i1][j1]});
            q1.add(new int[]{i1-1,j1,grid[i1][j1]});
            q1.add(new int[]{i1,j1+1,grid[i1][j1]});
            q1.add(new int[]{i1,j1-1,grid[i1][j1]});
        }
    }
}
