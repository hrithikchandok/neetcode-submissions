class Solution {
    public void setZeroes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        boolean firstRow = false;
        boolean firstCol = false;

        // check first row
        for (int j = 0; j < n; j++) {
            if (mat[0][j] == 0) {
                firstRow = true;
                break;
            }
        }

        // check first column
        for (int i = 0; i < m; i++) {
            if (mat[i][0] == 0) {
                firstCol = true;
                break;
            }
        }

        // mark rows and columns
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        // set zeroes
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        // first row
        if (firstRow) {
            for (int j = 0; j < n; j++) {
                mat[0][j] = 0;
            }
        }

        // first column
        if (firstCol) {
            for (int i = 0; i < m; i++) {
                mat[i][0] = 0;
            }
        }
    }
}
