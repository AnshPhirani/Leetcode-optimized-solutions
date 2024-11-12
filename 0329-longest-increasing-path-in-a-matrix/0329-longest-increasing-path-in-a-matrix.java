class Solution {
    
    Integer[][] memo;
    
    private int dfs(int i, int j, int[][] matrix){
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) return 0;
        if(memo[i][j] != null) return memo[i][j];
        
        int curIncreasingPath = 0;
        if(i-1 >= 0 && matrix[i-1][j] > matrix[i][j]) curIncreasingPath = Math.max(curIncreasingPath, dfs(i-1, j, matrix));
        if(j+1 < matrix[0].length && matrix[i][j+1] > matrix[i][j]) curIncreasingPath = Math.max(curIncreasingPath, dfs(i, j+1, matrix));
        if(i+1 < matrix.length && matrix[i+1][j] > matrix[i][j]) curIncreasingPath = Math.max(curIncreasingPath, dfs(i+1, j, matrix));
        if(j-1 >= 0 && matrix[i][j-1] > matrix[i][j]) curIncreasingPath = Math.max(curIncreasingPath,dfs(i, j-1, matrix));
        
        return memo[i][j] = 1 + curIncreasingPath;
        
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        this.memo = new Integer[n][m];
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(memo[i][j] == null) dfs(i, j, matrix);
                ans = Math.max(ans, memo[i][j]);
            }
        }
        
        return ans;
    }
}