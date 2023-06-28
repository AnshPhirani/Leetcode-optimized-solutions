class Solution {
    
    double res = 0;
    List<List<double[]>> adj;
    boolean[] visited;
    
    private void dfs(int start, int end, double probability){
        if(probability < 1d/100000) return;
        
        if(start == end){
            res = Math.max(res, probability);
            return;
        }

        if(visited[start]) return;  
        
        visited[start] = true;
        
        for(double[] neigh : adj.get(start)){
            if(!visited[(int)neigh[0]] && neigh[1]*probability >= res)
                dfs((int)neigh[0], end, neigh[1]*probability);
        }
        visited[start] = false;
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        this.adj = new ArrayList<>();
        this.visited = new boolean[n];
        
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        int i = 0;
        for(int[] edge : edges){
            adj.get(edge[0]).add(new double[]{edge[1], succProb[i]});
            adj.get(edge[1]).add(new double[]{edge[0], succProb[i]});
            i++;
        }
        
        dfs(start, end, 1);
        return res;
    }
}