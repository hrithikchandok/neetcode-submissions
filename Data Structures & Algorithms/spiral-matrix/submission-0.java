class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer>ans=new ArrayList<>();
        int m=mat.length;
        int n=mat[0].length;

        int first_row=0;
        int last_row=m-1;
        int first_col=0;
        int last_col=n-1;
       while(first_row<=last_row && first_col<=last_col){ 
        // first row 
        for(int j=first_col;j<=last_col;j++){
            ans.add(mat[first_row][j]);
        }
        first_row++;
        //last col
        for(int i=first_row;i<=last_row;i++){
            ans.add(mat[i][last_col]);
        }
        last_col--;

        // last row
        if (first_row <= last_row) {
        for(int j=last_col;j>=first_col;j--){
            ans.add(mat[last_row][j]);
        }
        last_row--;
        }

        //first_col
        if(first_col<=last_col){
        for(int i=last_row;i>=first_row;i--){
            ans.add(mat[i][first_col]);
        }
        first_col++;}
       }


        return ans;
    }
}
