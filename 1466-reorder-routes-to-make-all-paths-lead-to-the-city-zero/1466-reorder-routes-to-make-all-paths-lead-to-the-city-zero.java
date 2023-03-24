class Solution {
    
    List<List<int[]>> adj;
    
    private int dfs(int u, boolean[] visited){

        visited[u] = true;
        int change = 0;
        
        for(int[] v : adj.get(u)){
            if(!visited[v[0]]) change += dfs(v[0], visited) + v[1];
        }
        
        return change;
    }
    
    public int minReorder(int n, int[][] connections) {
        this.adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for(int[] connection : connections){
            int u = connection[0];
            int v = connection[1];
            adj.get(u).add(new int[]{v, 1}); // forward edge (original edge)
            adj.get(v).add(new int[]{u, 0}); // reverse edge
        }
        
        boolean[] visited = new boolean[n];
        return dfs(0, visited);
        
    }
}