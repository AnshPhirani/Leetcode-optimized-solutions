class Solution {
    List<List<Integer>> adj;
    List<Boolean> hasApple;
    
    private int dfs(int u, int parent){
        int totalTime = 0;
        
        for(int v : adj.get(u)){
            if(v == parent) continue;
            int curTime = dfs(v, u);
            totalTime += curTime;
        }
        
        return (hasApple.get(u) || totalTime > 0) ? totalTime+2 : 0;
    }
    
    public int minTime(int n, int[][] edges,  List<Boolean> hasApple) {
        this.hasApple = hasApple;
        this.adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int totalTime = dfs(0, -1);
        if(totalTime == 0) return 0;
        else return totalTime-2;
    }
}