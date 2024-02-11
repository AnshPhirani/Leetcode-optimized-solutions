class Solution {
    
    private int[] dir = {0, 1, -1};
    private Integer[][][] dp;
    
    public int cherryPickup(int[][] grid) {
        dp = new Integer[70][70][70];
        return helper(grid, 0, 0, grid[0].length-1);
    }
    
    private int helper(int[][] grid, int idx, int j1, int j2){
        if(idx == grid.length){
            return 0;
        }
        if(j1 < 0 || j2 < 0 || j1 >= grid[0].length || j2 >= grid[0].length){
            return Integer.MIN_VALUE;
        }
        
        if(dp[idx][j1][j2] != null){
            return dp[idx][j1][j2];
        }
        
        int curVal = (j1 == j2) ? grid[idx][j1] : grid[idx][j1] + grid[idx][j2];
        int ans = Integer.MIN_VALUE;
        for(int x : dir){
            for(int y : dir){
                ans = Math.max(ans, curVal + helper(grid, idx+1, j1+x, j2+y));
            }
        }
        
        return dp[idx][j1][j2] = ans;
    }
} 