class Solution {
    
    long fuel;
    
    private int dfs(int src, int parent, List<List<Integer>> adj, int seats){
        
        int representatives = 1;
        
        for(int dest : adj.get(src)){
            if(dest == parent) continue;
            representatives += dfs(dest, src, adj, seats);
        }
        
        if(src != 0) fuel += Math.ceil(1d * representatives/seats);
        
        return representatives;
        
        
    }
    
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i  = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for(int[] road : roads){
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
        
        this.fuel = 0;
        dfs(0, -1, adj, seats);
        return fuel;
        
    }
}