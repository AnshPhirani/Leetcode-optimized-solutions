class Solution {
    
    private int[] calculateLocation(int label, int n){
        int row = (n-1) - (label-1)/n;
        int col = (n-1-row)%2 == 0 ? (label-1)%n : (n-1) - (label-1)%n;  
        // System.out.println(label + " = [" + row + ", " + col + "]");
        return new int[]{row, col};
    }
    
    
    public int snakesAndLadders(int[][] board) {   
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{1, 0});
        visited[n-1][0] = true;
        
        while(!que.isEmpty()){
            int curLabel = que.peek()[0];
            int curSteps = que.peek()[1];
            que.poll();
            
            if(curLabel == n*n) return curSteps;
            
            for(int i = 1; i <= 6 && curLabel+i <= n*n; i++){
                int[] location = calculateLocation(curLabel+i, n);
                int x = location[0], y = location[1];
                if(visited[x][y]) continue;
                visited[x][y] = true;
                
                if(board[x][y] != -1){
                    que.add(new int[]{board[x][y], curSteps+1}); 
                }
                else{
                    que.add(new int[]{curLabel+i, curSteps+1});
                }
            }
            
        }
        
        return -1;
    }
}