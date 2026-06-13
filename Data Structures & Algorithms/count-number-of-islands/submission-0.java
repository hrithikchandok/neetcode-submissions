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
    public int numIslands(char[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int count=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfshelper(i,j,grid);
                }
            }
        }
        return count;
    }
}
