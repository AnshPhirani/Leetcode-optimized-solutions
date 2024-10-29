class Solution {
    Integer[][] memo;
    
    private int dfs(int i, int j, int[][] grid){
        int n = grid.length, m = grid[0].length;
        if(i < 0 || j < 0 || i == n || j == m) return 0;
        if(j+1 == m) return 0;
        
        if(memo[i][j] != null) return memo[i][j];
        
        int curMaxMoves = 0;
        if(i-1 >= 0 && grid[i-1][j+1] > grid[i][j]) curMaxMoves = Math.max(curMaxMoves, 1 + dfs(i-1, j+1, grid));
        if(grid[i][j+1] > grid[i][j]) curMaxMoves = Math.max(curMaxMoves, 1 + dfs(i, j+1, grid));
        if(i+1 < n && grid[i+1][j+1] > grid[i][j]) curMaxMoves = Math.max(curMaxMoves, 1 + dfs(i+1, j+1, grid));
        
        return memo[i][j] = curMaxMoves;   
    }
    
    public int maxMoves(int[][] grid) {
        this.memo = new Integer[grid.length][grid[0].length];
        int maxMoves = 0;
        for(int i = 0; i < grid.length; i++){
            maxMoves = Math.max(maxMoves, dfs(i, 0, grid));
        }
        
        return maxMoves;
    }
}