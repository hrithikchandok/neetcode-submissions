class Solution {
    public void solve(char[][] grid) {
        if (grid == null || grid.length == 0) return;
        
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> q1 = new LinkedList<>();

        // 1. Find all 'O's on the borders and add them to the queue
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 'O' && (i == 0 || j == 0 || i == r - 1 || j == c - 1)) {
                    q1.add(new int[] {i, j});
                }
            }
        }

        // 2. BFS to mark all border-connected 'O's as safe ('1')
        while (!q1.isEmpty()) {
            int[] curr = q1.poll();
            int i1 = curr[0];
            int j1 = curr[1];

            // If out of bounds or NOT an 'O', skip it
            if (i1 < 0 || j1 < 0 || i1 >= r || j1 >= c || grid[i1][j1] != 'O') {
                continue;
            }

            // Mark as safe
            grid[i1][j1] = '1';

            // Move in four directions
            q1.add(new int[] {i1 + 1, j1});
            q1.add(new int[] {i1 - 1, j1});
            q1.add(new int[] {i1, j1 + 1});
            q1.add(new int[] {i1, j1 - 1});
        }

        // 3. Flip remaining 'O's to 'X', and safe '1's back to 'O'
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                } else if (grid[i][j] == '1') {
                    grid[i][j] = 'O';
                }
            }
        }
    }
}