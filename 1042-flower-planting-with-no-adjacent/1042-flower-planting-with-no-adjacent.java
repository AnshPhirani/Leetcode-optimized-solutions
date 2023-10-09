class Solution {
    
    private void dfs(int src, int[] res, Set<Integer>[] adj){
        if(res[src] != -1) return;
        
        Set<Integer> neighFlowers = new HashSet<>();
        for(int neigh : adj[src]){
            neighFlowers.add(res[neigh]);
        }
        for(int flower = 1; flower <= 4; flower++){
            if(!neighFlowers.contains(flower)){
                res[src] = flower;
                break;
            }
        }
        
        for(int neigh : adj[src]){
            if(res[neigh] == -1) dfs(neigh, res, adj);
        }
        
    }
    
    public int[] gardenNoAdj(int n, int[][] paths) {
        Set<Integer>[] adj = new Set[n];
        for(int i = 0; i < n; i++) adj[i] = new HashSet<>();
        for(int[] path : paths){
            int u = path[0]-1, v = path[1]-1;
            adj[u].add(v);
            adj[v].add(u);
        }
        
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for(int i = 0; i < n; i++){
            if(res[i] == -1) dfs(i, res, adj);
        }
        
        return res;
        
    }
}