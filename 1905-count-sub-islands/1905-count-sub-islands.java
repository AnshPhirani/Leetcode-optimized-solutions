class Solution {
    
    private boolean dfs(int i, int j, int[][] grid1, int[][] grid2){
        
        if(i < 0 || j < 0 || i >= grid1.length || j >= grid1[0].length || grid2[i][j] != 1) return true;
        
        boolean ans = true;
        if(grid1[i][j] == 0) ans = false;
        
        grid2[i][j] = -1; // visited
        
        return ans & dfs(i+1, j, grid1, grid2) & dfs(i-1, j, grid1, grid2) & dfs(i, j+1, grid1, grid2) & dfs(i, j-1, grid1, grid2);
        
    }
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        
        int ans = 0;
        for(int i =0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid2[i][j] == 1 && dfs(i, j, grid1, grid2)){
                    ans++;
                }
            }
        }
        
        return ans;
        
    }
}