class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> que = new LinkedList<>();
        int[][] distance = new int[n][n];
        
        for(int[] dist : distance) Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) {
                    que.add(new int[]{i, j});
                    distance[i][j] = 0;
                }
            }
        }
        
        int maxDistance = -1;
        
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while(!que.isEmpty()){
            int[] cur = que.poll();
            for(int[] delta : dir){
                int x = cur[0]+delta[0];
                int y = cur[1]+delta[1];
                int curDist = Math.abs(delta[0]+delta[1]);
                if(x < 0 || y < 0 || x >= n || y >= n) continue;
                if(grid[x][y] == 0 && distance[cur[0]][cur[1]] + curDist < distance[x][y]){
                    distance[x][y] = distance[cur[0]][cur[1]] + curDist;
                    maxDistance = Math.max(maxDistance, distance[x][y]);
                    que.add(new int[]{x, y});
                }
            }
        }
        
        
        return maxDistance;
        
    }
}