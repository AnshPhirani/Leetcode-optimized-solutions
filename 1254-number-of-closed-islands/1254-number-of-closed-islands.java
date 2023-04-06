class Solution {
    
    private boolean dfs(int i, int j, int n, int m, int[][] grid, boolean[][] visited){
        if(i >= n || j >= m || i < 0 ||  j < 0) return false;
        if(grid[i][j] == 1 || visited[i][j] == true) return true;
        
        visited[i][j] = true;
        
        // use single & here is important 
        return dfs(i-1, j, n, m, grid, visited) & dfs(i, j+1, n, m, grid, visited)
            & dfs(i+1, j, n, m, grid, visited) & dfs(i, j-1, n, m, grid, visited);
        
    }
    
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && grid[i][j] == 0 && dfs(i, j, n, m, grid, visited)){
                    count++;
                }
            }
        }
        return count;
    }
}