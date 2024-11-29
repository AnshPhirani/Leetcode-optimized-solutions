class Solution {
    
    public int minimumTime(int[][] grid) {
        
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1; 
        
        int n = grid.length, m = grid[0].length;
        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        pq.add(new int[]{0, 0, 0});
        grid[0][0] = -1;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int t = cur[0], x = cur[1], y = cur[2];
            if(x == n-1 && y == m-1) return t;
            
            if(visited[x][y]) continue;
            visited[x][y] = true;
            
            for(int[] d : dir){
                int i = x+d[0], j = y+d[1];
                if(i < 0 || j < 0 || i >= n || j >= m || visited[i][j]) continue;
                int waitTime = (grid[i][j] - t)%2 == 0 ? 1 : 0;
                int nextTime = Math.max(grid[i][j]+waitTime, t+1);
                pq.add(new int[]{nextTime, i, j});
            }
        }
        
        return -1;
        
    }
}