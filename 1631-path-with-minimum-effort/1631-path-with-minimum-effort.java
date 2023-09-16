class Solution {
    
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        
        int[][] dist = new int[n][m];
        for(int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        pq.add(new int[]{0, 0, 0});
        dist[0][0] = 0;
        
        while(!pq.isEmpty()){
            int[] curCell = pq.poll();
            int i = curCell[0], j = curCell[1], curMaxEffort = curCell[2];
            if(i == n-1 && j == m-1) return curMaxEffort;
            
            for(int[] d : dir){
                int x = curCell[0]+d[0], y = curCell[1]+d[1];
                if(x < 0 || y < 0 || x >= n || y >= m) continue;
                
                int newMaxEffort = Math.max(curMaxEffort, Math.abs(heights[i][j]-heights[x][y]));
                if(newMaxEffort < dist[x][y]){
                    dist[x][y] = newMaxEffort;
                    pq.add(new int[]{x, y, newMaxEffort});
                }

            }
        }
        
        return -1; // never reaches here
        
    }
}