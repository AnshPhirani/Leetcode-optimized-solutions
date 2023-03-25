class Solution {
    
    List<List<Integer>> adj;
    
    
    private long dfs(int u, boolean[] visited){
        visited[u] = true;
        int nodesCount = 1;
        
        for(int v : adj.get(u)){
            if(!visited[v]) nodesCount += dfs(v, visited);
        }
        
        return nodesCount;
    }
    
    public long countPairs(int n, int[][] edges) {
        adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        long pairsCount = 0;
        long visitedNodesCount = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                long curNodesCount = dfs(i, visited);
                pairsCount += curNodesCount*visitedNodesCount;
                visitedNodesCount += curNodesCount;
            }
        }
        
        return pairsCount;
    }
}