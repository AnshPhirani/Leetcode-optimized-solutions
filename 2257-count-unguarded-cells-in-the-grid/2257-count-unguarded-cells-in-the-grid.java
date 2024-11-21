class Solution {

    private static final int UNGUARDED = 0;
    private static final int GUARDED = 1;
    private static final int GUARD = 2;
    private static final int WALL = 3;

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // Create and initialize grid
        int[][] grid = new int[m][n];

        // Mark guards' positions
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = GUARD;
        }

        // Mark walls' positions
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = WALL;
        }

        // Horizontal passes
        for (int row = 0; row < m; row++) {
            // Left to right pass
            boolean isGuardLineActive = grid[row][0] == GUARD;
            for (int col = 1; col < n; col++) {
                isGuardLineActive = updateCellVisibility(
                    grid,
                    row,
                    col,
                    isGuardLineActive
                );
            }

            // Right to left pass
            isGuardLineActive = grid[row][n - 1] == GUARD;
            for (int col = n - 2; col >= 0; col--) {
                isGuardLineActive = updateCellVisibility(
                    grid,
                    row,
                    col,
                    isGuardLineActive
                );
            }
        }

        // Vertical passes
        for (int col = 0; col < n; col++) {
            // Top to bottom pass
            boolean isGuardLineActive = grid[0][col] == GUARD;
            for (int row = 1; row < m; row++) {
                isGuardLineActive = updateCellVisibility(
                    grid,
                    row,
                    col,
                    isGuardLineActive
                );
            }

            // Bottom to top pass
            isGuardLineActive = grid[m - 1][col] == GUARD;
            for (int row = m - 2; row >= 0; row--) {
                isGuardLineActive = updateCellVisibility(
                    grid,
                    row,
                    col,
                    isGuardLineActive
                );
            }
        }

        // Count unguarded cells
        int count = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == UNGUARDED) {
                    count++;
                }
            }
        }

        return count;
    }

    // Helper method to update cell visibility
    private boolean updateCellVisibility(
        int[][] grid,
        int row,
        int col,
        boolean isGuardLineActive
    ) {
        // If current cell is a guard, reactivate the guard line
        if (grid[row][col] == GUARD) {
            return true;
        }

        // If current cell is a wall, deactivate the guard line
        if (grid[row][col] == WALL) {
            return false;
        }

        // If guard line is active, mark cell as guarded
        if (isGuardLineActive) {
            grid[row][col] = GUARDED;
        }

        return isGuardLineActive;
    }
}