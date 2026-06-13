class Solution {
    private void dfshelper(int i,int j,char grid[][]){
        // if(grid[i][j]=='0')return;
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0')return;
        grid[i][j]='0';
        // move all direction
        dfshelper(i+1,j,grid);
        dfshelper(i-1,j,grid);
        dfshelper(i,j+1,grid);
        dfshelper(i,j-1,grid);
        
    }
    private void bfshelper(int i,int j , char grid[][]){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0')return;
        Queue<int[]>q1=new LinkedList<>();
        q1.add(new int[]{i,j});
        while(q1.size()>0){
            int curr[]=q1.poll();
            int i1=curr[0];
            int j1=curr[1];
            if(i1<0||j1<0||i1>=grid.length||j1>=grid[0].length||grid[i1][j1]=='0')continue;
            grid[i1][j1]='0';
            // move four direction
            q1.add(new int[]{i1+1,j1});
            q1.add(new int[]{i1-1,j1});
            q1.add(new int[]{i1,j1+1});
            q1.add(new int[]{i1,j1-1});
        }
        
    }
    public int numIslands(char[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int count=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1'){
                    count++;
                    bfshelper(i,j,grid);
                }
            }
        }
        return count;
    }
}
