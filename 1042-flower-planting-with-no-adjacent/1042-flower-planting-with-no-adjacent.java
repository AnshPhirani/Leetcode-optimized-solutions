class Solution {
    
    public int[] gardenNoAdj(int n, int[][] paths) {
        Set<Integer>[] adj = new Set[n];
        for(int i = 0; i < n; i++) adj[i] = new HashSet<>();
        for(int[] path : paths){
            int u = path[0]-1, v = path[1]-1;
            adj[u].add(v);
            adj[v].add(u);
        }
        
        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            Set<Integer> neighFlowers = new HashSet<>();
            for(int neigh : adj[i]){
                neighFlowers.add(res[neigh]);
            }
            for(int flower = 1; flower <= 4; flower++){
                if(!neighFlowers.contains(flower)){
                    res[i] = flower;
                    break;
                }
            }
        }
        
        return res;
        
    }
}