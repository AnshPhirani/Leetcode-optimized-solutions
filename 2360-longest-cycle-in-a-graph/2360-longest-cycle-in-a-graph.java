class Solution {
    
    private int dfs(int u, int[] edges, boolean[] visited, Map<Integer, Integer> dist){
        visited[u] = true;
        
        int v = edges[u];
        if(v != -1 && dist.containsKey(v)){
            return dist.get(u)- dist.get(v)+ 1;
        }
        else if(v != -1 && !visited[v]){
            dist.put(v, dist.get(u) + 1);
            return dfs(v, edges, visited, dist);
        }
        else{
            return -1;
        }
    }
    
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int largestCycle = -1;
        
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                Map<Integer, Integer> dist = new HashMap<>();
                dist.put(i, 0);
                largestCycle = Math.max(largestCycle, dfs(i, edges, visited, dist));
            }
                
        }
        
        return largestCycle;
    }
}