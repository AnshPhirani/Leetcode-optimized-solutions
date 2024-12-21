class Solution {
    
    private int dfs(int root, int parent,  List<List<Integer>> adj,  int[] values, int k){
        int count = 0;
        for(int child : adj.get(root)){
            if(child == parent) continue;
            count += dfs(child, root, adj, values, k);
        }
        
        if(values[root]%k == 0) return count + 1;
        values[parent] += values[root]%k;
        return count;
    }
    
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
            
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        return dfs(0, -1, adj, values, k);
    }
}