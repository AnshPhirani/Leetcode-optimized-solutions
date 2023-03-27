class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0, grid[0][0]}); // [i, j, pathSum]
        int minSum = Integer.MAX_VALUE;
        
        int[][] memo = new int[n][m];
        for(int[] me : memo) Arrays.fill(me, Integer.MAX_VALUE);
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int i = cur[0], j = cur[1], curSum = cur[2];
            if(i == n-1 && j == m-1){
                minSum = Math.min(minSum, curSum);
            }
            
            if(i+1 < n && curSum+grid[i+1][j] < memo[i+1][j]){
                memo[i+1][j] = curSum+grid[i+1][j];
                que.add(new int[]{i+1, j, curSum+grid[i+1][j]});
            }
            if(j+1 < m && curSum+grid[i][j+1] < memo[i][j+1]){
                memo[i][j+1] = curSum+grid[i][j+1];
                que.add(new int[]{i, j+1, curSum+grid[i][j+1]});
            }
        }
        
        return minSum;
    }
}