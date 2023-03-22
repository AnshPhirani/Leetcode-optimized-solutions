class Solution {
    
    private int dfs(int src, List<List<int[]>> adj, boolean[] visited){
        if(visited[src]) return Integer.MAX_VALUE;
        visited[src] = true;
        
        int minDistance = Integer.MAX_VALUE;
        for(int[] neigh : adj.get(src)){
            minDistance = Math.min(minDistance, Math.min(neigh[1], dfs(neigh[0], adj, visited)));
        }
        
        return minDistance;
    }
    
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for(int[] road : roads){
            adj.get(road[0]-1).add(new int[]{road[1]-1, road[2]});
            adj.get(road[1]-1).add(new int[]{road[0]-1, road[2]});
        }
        
        
        return dfs(0, adj, new boolean[n]);
        
    }
}