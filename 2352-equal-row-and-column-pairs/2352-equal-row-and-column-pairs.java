class Solution {
    
    private boolean isEqual(int r, int c, int[][] grid){
        for(int i = 0; i < grid.length; i++){
            if(grid[r][i] != grid[i][c]) return false;
        }
        return true;
    }
    
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;
        
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                if(isEqual(r, c, grid)) count++;
            }
        }
        
        return count;
        
    }
}