class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        
        // 1. Count fresh oranges and add all initially rotten oranges to the queue
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        
        // If there are no fresh oranges to begin with, it takes 0 minutes
        if (fresh == 0) return 0;
        
        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // 2. Process the queue level by level
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                
                // Check all 4 adjacent directions
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    
                    // If the adjacent cell is within bounds and has a fresh orange
                    if (newRow >= 0 && newRow < r && newCol >= 0 && newCol < c && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Mark as rotten (acts as our visited set)
                        fresh--;                  // Decrement our fresh count tracker
                        q.add(new int[]{newRow, newCol});
                    }
                }
            }
            minutes++; // Increment minutes after fully processing the current level
        }
        
        // 3. If there are still fresh oranges left, they were unreachable
        return fresh == 0 ? minutes : -1;
    }
}