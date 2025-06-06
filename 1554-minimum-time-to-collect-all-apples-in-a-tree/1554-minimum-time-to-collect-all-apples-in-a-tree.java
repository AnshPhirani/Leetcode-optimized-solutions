class Solution {

    private int dfs(int root, int parent, List<List<Integer>> adj, List<Boolean> hasApple){
        
        int totalTime = 0;
        for(int children : adj.get(root)){
            if(children == parent) continue;
            int childTime = dfs(children, root, adj, hasApple);
            if(hasApple.get(children) || childTime > 0){
                totalTime += 2 + childTime;
            }

        }

        return totalTime;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return dfs(0, -1, adj, hasApple);

    }
}