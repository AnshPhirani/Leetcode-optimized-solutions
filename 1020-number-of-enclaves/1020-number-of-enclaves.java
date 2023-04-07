class Solution {
    
    
    private int dfs(int i, int j, int n, int m, int[][] grid){
        if(i < 0 || j < 0 || i >= n || j >= m){
            return -1;
        }
        if(grid[i][j] == 0) return 0;
        
        if(grid[i][j] == -1) return 0;
        
        grid[i][j] = -1;
        
        int res = 0;
        
        int top = dfs(i-1, j, n, m, grid);
        if(top == -1) res = -1;
        
        int left = dfs(i, j+1, n, m, grid);
        if(left == -1) res = -1;
        
        int bottom = dfs(i+1, j, n, m, grid);
        if(bottom == -1) res = -1;
        
        int right = dfs(i, j-1, n, m, grid);
        if(right == -1) res = -1;
        
        return res == -1 ? -1 : 1 + top+left+bottom+right;
    }
    
    
    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int cur = dfs(i, j, n, m, grid);
                    if(cur != -1) res += cur;
                }
            }
        }
        
        return res;
        
    }
}