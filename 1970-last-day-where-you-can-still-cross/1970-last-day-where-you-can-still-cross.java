class Solution {
    
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    private boolean bfs(int idx, int row, int col, Map<Pair<Integer, Integer>, Integer> cellToIdx){
        Queue<Pair<Integer, Integer>> que = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        
        for(int j = 0; j < col; j++){
            if(cellToIdx.getOrDefault(new Pair<>(0, j), Integer.MAX_VALUE) <= idx) continue;
            que.add(new Pair<>(0, j));
            visited[0][j] = true;
        }
        
        while(!que.isEmpty()){
            Pair<Integer, Integer> cur = que.poll();
            
            if(cur.getKey() == row-1) return true;
            
            for(int[] d : dir){
                int x = cur.getKey() + d[0];
                int y = cur.getValue() + d[1];
                if(x < 0 || y < 0 || x >= row || y >= col || visited[x][y]) continue;
                if(cellToIdx.getOrDefault(new Pair<>(x, y), Integer.MAX_VALUE) <= idx) continue;
                que.add(new Pair<>(x, y));
                visited[x][y] = true;
            }
        }
        
        return false;
    }
    
    public int latestDayToCross(int row, int col, int[][] cells) {
        int n = cells.length;
        
        Map<Pair<Integer, Integer>, Integer> cellToIdx = new HashMap<>();
        for(int i = 0; i < n; i++){
            cellToIdx.put(new Pair<>(cells[i][0]-1, cells[i][1]-1), i);
        }
        
        
        int low = 0, high = n-1;
        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(bfs(mid, row, col, cellToIdx)){
                low = mid+1;
                ans = mid;
            }
            else{
                high = mid-1;
            }
        }
        
        return ans+1;
    }
}