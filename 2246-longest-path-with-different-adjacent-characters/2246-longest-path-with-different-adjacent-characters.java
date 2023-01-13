class Solution {
    
    List<Integer>[] adj;
    String s;
    int res = 0;
    
    private int dfs(int u, int parent){
        
        char parentChar = s.charAt(u);
        int longestPath1 = 0, longestPath2 = 0;
        
        for(int v : adj[u]){
            if(v == parent) continue;
            
            char curChildChar = s.charAt(v);
            int curChildPath = dfs(v, u);
            if(parentChar == curChildChar) curChildPath = 0;
            
            if(curChildPath >= longestPath1){
                longestPath2 = longestPath1;
                longestPath1 = curChildPath;
            }
            else if(curChildPath > longestPath2){
                longestPath2 = curChildPath;
            }
        }
        
        res = Math.max(res, 1 + longestPath1 + longestPath2);
        return 1 + longestPath1;
        
    }
    
    
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        this.adj = new ArrayList[n];
        this.s = s;
        
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for(int i = 1; i < n; i++){
            adj[i].add(parent[i]);
            adj[parent[i]].add(i);
        }
        
        dfs(0, -1);
        return res;
    }
}