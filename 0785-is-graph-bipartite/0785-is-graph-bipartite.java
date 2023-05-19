class Solution {
    
    private boolean isBipartite(int u, int[][] graph, int[] color){    
        if(color[u] == -1) color[u] = 0;
        
        for(int v : graph[u]){
            if(color[v] == -1){
                color[v] = 1-color[u];
                if(!isBipartite(v, graph, color)) return false;
            }
            else if(color[v] != 1 - color[u]){
                return false;
            }
        }
        
        return true;
        
    }
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        for(int i = 0; i < n; i++){
            if(color[i] == -1 && !isBipartite(i, graph, color)){
                return false;
            }
        }
        
        return true;
        
    }
}