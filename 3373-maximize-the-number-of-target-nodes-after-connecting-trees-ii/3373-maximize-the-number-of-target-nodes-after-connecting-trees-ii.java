class Solution {

    private boolean[] visited;
    
    private int dfs(int src, int parent, List<List<Integer>> adj, boolean[] parity, boolean isEven){
        parity[src] = isEven;
        int evenCount = isEven ? 1 : 0;
        for(int neigh : adj.get(src)){
            if(neigh == parent) continue;
            evenCount += dfs(neigh, src, adj, parity, !isEven);
        }
        return evenCount;
    }
    
    private List<List<Integer>> getAdjList(int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= edges.length; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0], v= edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
    
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        
        int n = edges1.length+1, m = edges2.length+1;
        
        boolean[] parity = new boolean[n];
        
        int even1 = dfs(0, -1, getAdjList(edges1), parity, true), odd1 = n-even1;
        int even2 = dfs(0, -1, getAdjList(edges2), new boolean[m], true), odd2 = m-even2;

    
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] += (parity[i] ? even1 : odd1) + Math.max(even2, odd2);
        }
        return ans;
    
    }
}