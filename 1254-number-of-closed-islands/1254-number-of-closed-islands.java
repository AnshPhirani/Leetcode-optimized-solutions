class Solution {
    
    private boolean dfs(int i, int j, int n, int m, int[][] grid){
        if(i >= n || j >= m || i < 0 ||  j < 0) return false;
        if(grid[i][j] == 1) return true;
        
        grid[i][j] = 1;
        
        // use single & here is important 
        return dfs(i-1, j, n, m, grid) & dfs(i, j+1, n, m, grid)
            & dfs(i+1, j, n, m, grid) & dfs(i, j-1, n, m, grid);
        
    }
    
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0 && dfs(i, j, n, m, grid)){
                    count++;
                }
            }
        }
        return count;
    }
}