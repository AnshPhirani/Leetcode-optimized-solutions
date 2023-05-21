class Solution {
    Queue<int[]> que;
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    private void dfs(int i, int j, int n, int[][] grid){
        if(i < 0 || j < 0 || i >= n || j >= n || grid[i][j] == 0 || grid[i][j] == -1){
            return;
        }
        
        grid[i][j] = -1;
        que.add(new int[]{i, j});
        
        dfs(i+1, j, n, grid);
        dfs(i-1, j, n, grid);
        dfs(i, j+1, n, grid);
        dfs(i, j-1, n, grid);
        
    }
    
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        que = new LinkedList<>();
        
        outerloop:
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                     dfs(i, j, n, grid);
                     break outerloop;
                }   
            }
        }
        
        
        int dist = 0;
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int[] cur = que.poll();
                for(int[] d : dir){
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if(x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == -1) continue;

                    if(grid[x][y] == 1) return dist;
                    else{
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