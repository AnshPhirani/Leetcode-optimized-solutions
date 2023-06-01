class Solution {
    
    private static int[] dir = {-1, 0, 1};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0});
        grid[0][0] = -1;
        int dist = 1;
        
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int[] cur = que.poll();
                
                if(cur[0] == n-1 && cur[1] == n-1) return dist;
                
                for(int dx : dir){
                    for(int dy : dir){
                        int x = cur[0]+dx;
                        int y = cur[1]+dy;
                        if(x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == 1 || grid[x][y] == -1){
                            continue;
                        }
                        que.add(new int[]{x, y});
                        grid[x][y] = -1;
                    }
                }
            }
            dist++;
        }
        
        return -1;
        
    }
}