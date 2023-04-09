class Solution {
    
    Map<Integer, int[]> memo;
    List<List<Integer>> adj;
    boolean hasCycle;
    int maxColorFreq;
    
    private void dfs(int u, String colors, boolean[] visited){
        
        if(visited[u]){
            hasCycle = true;
            return;
        }
        visited[u] = true;
        
        int[] curFreq = new int[26];
        
        for(int v : adj.get(u)){
            if(!memo.containsKey(v)) dfs(v, colors, visited);
            if(hasCycle) return;
            int[] nextFreq = memo.get(v);
            for(int i = 0; i < 26; i++){
                curFreq[i] = Math.max(curFreq[i], nextFreq[i]);
            }
        }
        
        visited[u] = false;
        curFreq[colors.charAt(u) - 'a']++;
        for(int curColorFreq : curFreq) maxColorFreq = Math.max(maxColorFreq, curColorFreq);
        memo.put(u, curFreq);
    }
    
    
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        this.memo = new HashMap<>();
        this.adj = new ArrayList<>();
        this.hasCycle = false;
        this.maxColorFreq = 0;
        
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!memo.containsKey(i)) dfs(i, colors, visited);
            if(hasCycle) return -1;
        }

        return maxColorFreq;
        
    }
}