class Solution {
    public int minimumArea(int[][] grid) {
        int top = Integer.MAX_VALUE, left = Integer.MAX_VALUE, bottom = -1, right = -1;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    top = Math.min(top, i);
                    left = Math.min(left, j);
                    bottom = Math.max(bottom, i);
                    right = Math.max(right, j);
                }
            }
        }
        return (bottom-top+1)*(right-left+1);
    }
}