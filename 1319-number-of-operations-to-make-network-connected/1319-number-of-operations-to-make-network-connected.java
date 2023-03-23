class Solution {
    
    private void dfs(int u, List<List<Integer>> adj, boolean[] visited){
        if(visited[u]) return;
        visited[u] = true;
        for(int v : adj.get(u)) dfs(v, adj, visited);
    }
    
    public int makeConnected(int n, int[][] connections) {
        
        if(connections.length < n-1) return -1; // not possible
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] connection : connections){
            int u = connection[0];
            int v = connection[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int totalComponents = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                totalComponents++;
                dfs(i, adj, visited);
            }
        }
        
        return totalComponents-1;
        
    }
}