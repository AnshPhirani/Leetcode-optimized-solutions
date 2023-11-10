class Solution {
    
    int idx;
    int[] result;
    private void dfs(int src, Map<Integer, List<Integer>> adj, Set<Integer> visited){
        if(visited.contains(src)) return;
        result[idx++] = src;
        visited.add(src);
        for(int neigh : adj.get(src)){
            dfs(neigh, adj, visited);
        }
    }
    
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length+1;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        // for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        
        for(int[] pair: adjacentPairs){
            adj.putIfAbsent(pair[0], new ArrayList<>());
            adj.putIfAbsent(pair[1], new ArrayList<>());
            adj.get(pair[0]).add(pair[1]);    
            adj.get(pair[1]).add(pair[0]);
        }
        
        int firstEle = -1;
        for(int key : adj.keySet()){
            if(adj.get(key).size() == 1){
                firstEle = key;
                break;
            }
        }

        this.idx = 0;
        this.result = new int[n];
        dfs(firstEle, adj, new HashSet<>());
        return result;
        
    }
}