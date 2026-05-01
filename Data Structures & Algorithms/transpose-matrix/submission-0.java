class Solution {
    public int[][] transpose(int[][] mat) {
        int r=mat.length;
        int c=mat[0].length;
        if(r==c){
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    if(i<=j){
                        int temp=mat[i][j];
                        mat[i][j]=mat[j][i];
                        mat[j][i]=temp;
                    }
                }
            }
            return mat;    
        }
        int ans[][]=new int[c][r];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ans[j][i]=mat[i][j];
            }
        }
        return ans;
        
    }
}