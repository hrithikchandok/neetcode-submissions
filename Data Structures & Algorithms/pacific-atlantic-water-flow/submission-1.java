

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // DFS from left and right edges
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pacific, heights[r][0]);
            dfs(heights, r, cols - 1, atlantic, heights[r][cols - 1]);
        }

        // DFS from top and bottom edges
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pacific, heights[0][c]);
            dfs(heights, rows - 1, c, atlantic, heights[rows - 1][c]);
        }

        // Find intersection of both oceans
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] ocean, int prevHeight) {
        // Base case: check out of bounds, already visited, or if we are going "downhill"
        if (r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || 
            ocean[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        // Mark the current cell as reachable from the respective ocean
        ocean[r][c] = true;

        // Traverse in all 4 directions
        dfs(heights, r + 1, c, ocean, heights[r][c]);
        dfs(heights, r - 1, c, ocean, heights[r][c]);
        dfs(heights, r, c + 1, ocean, heights[r][c]);
        dfs(heights, r, c - 1, ocean, heights[r][c]);
    }
}