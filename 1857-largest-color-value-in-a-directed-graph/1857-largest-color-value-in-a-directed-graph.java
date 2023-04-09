class Solution {
    
    Map<Integer, int[]> memo;
    List<List<Integer>> adj;

    private int dfs(int u, String colors, boolean[] visited){
        
        if(visited[u]){
            return -1; // cycle found
        }
        visited[u] = true;
        
        int[] curFreq = new int[26];
        
        for(int v : adj.get(u)){
            if(!memo.containsKey(v)) {
                int curMaxFreq = dfs(v, colors, visited);
                if(curMaxFreq == -1) return -1; // has cycle
            }

            int[] nextFreq = memo.get(v);
            for(int i = 0; i < 26; i++){
                curFreq[i] = Math.max(curFreq[i], nextFreq[i]);
            }
        }
        
        visited[u] = false;
        curFreq[colors.charAt(u) - 'a']++;
        memo.put(u, curFreq);
        return Arrays.stream(curFreq).max().getAsInt();
    }
    
    
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        this.memo = new HashMap<>();
        this.adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        
        int maxColorFreq = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!memo.containsKey(i)) {
                int curMaxFreq = dfs(i, colors, visited);
                if(curMaxFreq == -1) return -1; // cycle
                maxColorFreq = Math.max(maxColorFreq, curMaxFreq);
            }
        }

        return maxColorFreq;
        
    }
}