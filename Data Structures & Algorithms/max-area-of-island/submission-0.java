class Solution {
    private int bfshelper(int i,int j,int [][]grid){
        Queue<int[]>q1=new LinkedList<>();
        q1.add(new int[]{i,j});
        int size=0;
        while(q1.size()>0){
            int i1=q1.peek()[0];
            int j1=q1.peek()[1];
            q1.poll();
            if(i1<0||j1<0||i1>=grid.length||j1>=grid[0].length||grid[i1][j1]==0)continue;
            size++;
            // mark as visited 
            grid[i1][j1]=0;
            // move all four direction
            q1.add(new int[]{i1+1,j1});
            q1.add(new int[]{i1-1,j1});
            q1.add(new int[]{i1,j1+1});
            q1.add(new int[]{i1,j1-1});

        }
        return size;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int count=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    count=Math.max(bfshelper(i,j,grid),count);
                }
            }
        }
        return count;
    }
}
