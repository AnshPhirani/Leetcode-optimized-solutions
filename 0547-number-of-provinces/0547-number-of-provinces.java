class Solution {
    
    private void dfs(int src, int[][] isConnected, boolean[] visited){
        visited[src] = true;
        
        for(int dest = 0; dest < isConnected.length; dest++){
            if(isConnected[src][dest] == 1 && !visited[dest]){
                dfs(dest, isConnected, visited);
            }
        }
        
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        int components = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, isConnected, visited);
                components++;
            }
        }
        
        return components;
    }
}