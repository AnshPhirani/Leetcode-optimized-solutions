class Solution {
    Set<Integer> terminalAndSafeNodes;
    boolean[] visited;
    
    private boolean dfs(int src, int[][] graph){
        if(terminalAndSafeNodes.contains(src)) return true;
        if(visited[src]) return false;
        
        visited[src] = true;
        for(int neigh : graph[src]){
            if(!dfs(neigh, graph)) return false;
        }
        
        terminalAndSafeNodes.add(src);
        return true;
    }
    
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length;
        
        terminalAndSafeNodes = new HashSet<>();
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            dfs(i, graph);
        }
        
        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(terminalAndSafeNodes.contains(i)) safeNodes.add(i);
        }
        return safeNodes;
    }
}