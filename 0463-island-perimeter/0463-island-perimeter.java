class Solution {
    int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int perimeter = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0) continue;
                for(int[] delta : deltas){
                    int x = i+delta[0];
                    int y = j+delta[1];
                    if(x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 0)
                        perimeter += 1;
                }
            }
        }
        
        return perimeter;
    }
}