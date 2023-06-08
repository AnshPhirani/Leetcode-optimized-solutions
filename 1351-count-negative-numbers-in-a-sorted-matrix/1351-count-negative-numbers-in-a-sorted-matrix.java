class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int i = 0, j = m-1;
        int count = 0;
        while(i < n && j >= 0){
            if(grid[i][j] < 0){
                count += n-i;
                j--;
            }
            else{
                i++;
            }
        }
        return count;
    }
}