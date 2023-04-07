class Solution {
    
    private void dfs(int i, int j, int n, int m, int[][] grid){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 1){
            return;
        }
        grid[i][j] = 1;
        dfs(i+1, j, n, m, grid);
        dfs(i-1, j, n, m, grid);
        dfs(i, j+1, n, m, grid);
        dfs(i, j-1, n, m, grid);
    }
    
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        for(int j = 0; j < m; j++){
            if(grid[0][j] == 0) dfs(0, j, n, m, grid);
            if(grid[n-1][j] == 0) dfs(n-1, j, n, m, grid);
        }
        
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 0) dfs(i, 0, n, m, grid);
            if(grid[i][m-1] == 0) dfs(i, m-1, n, m, grid);
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    dfs(i, j, n, m, grid);
                    count++;
                }
            }
        }
        return count;
    }
}