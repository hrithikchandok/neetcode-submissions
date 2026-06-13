class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        // 1. Add all treasures (0s) to the queue
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0) {
                    // We only need the coordinates, distance is tracked in the grid
                    q.add(new int[]{i, j}); 
                }
            }
        }

        // Array to easily loop through the 4 directions (up, down, left, right)
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 2. Multi-source BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check bounds and if the cell is an unvisited land cell (2147483647)
                if (newRow >= 0 && newRow < r && newCol >= 0 && newCol < c 
                    && grid[newRow][newCol] == 2147483647) {
                    
                    // Update the grid in-place with the distance
                    // This newly updated value also acts as our "visited" marker
                    grid[newRow][newCol] = grid[row][col] + 1;
                    
                    // Add the newly visited cell to the queue to explore its neighbors
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
    }
}