class Solution {
    private static final int MOD = (int)1e9+7;
    private static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private Integer[][] memo;
    
    private int dfs(int i, int j, int n, int m, int[][] grid){
        
        int ans = 1;
        
        if(memo[i][j] != null) return memo[i][j];
        
        for(int[] d : dir){
            int x = i+d[0], y = j+d[1];
            if(x >= 0 && x < n && y >= 0 && y < m && grid[x][y] < grid[i][j]){
                ans += dfs(x, y, n, m, grid);
                ans %= MOD;
            }
        }
        
        return memo[i][j] = ans;
    }
    
    public int countPaths(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        this.memo = new Integer[n][m];
        
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                res += dfs(i, j, n, m, grid);
                res %= MOD;
            }
        }
        return res;
    }
}