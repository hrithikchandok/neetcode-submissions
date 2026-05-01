class Solution {
    public static final void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
    public void rotate(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= j) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
        }
        int j1 = 0;
        int j2 = n - 1;
        while (j1 < j2) {
            for (int i = 0; i < n; i++) {
                // swap(mat[i][j1], mat[i][j2]);
                int temp = mat[i][j1];
                mat[i][j1] = mat[i][j2];
                mat[i][j2] = temp;
            }
            j1++;
            j2--;
        }
    }
}
