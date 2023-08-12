class Solution {
    
    Integer[][] memo;
    
    private int dfs(int row, int col, int[][] grid){
        if(row >= grid.length || col >= grid[0].length || grid[row][col] == 1) return 0;
        if(row == grid.length-1 && col == grid[0].length-1) return 1;
        
        if(memo[row][col] != null) return memo[row][col];
        
        return memo[row][col] = dfs(row+1, col, grid) + dfs(row, col+1, grid);
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.memo = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return dfs(0, 0, obstacleGrid);
    }
}