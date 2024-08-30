class Solution {
    
    private long dikstra(int src, int dest, int target, int n, List<List<Pair<Integer, Integer>>> adj){
        long[] dist = new long[n];
        Arrays.fill(dist, 999999999);
        dist[src] = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(src);
        while(!que.isEmpty()){
            int u = que.poll();
            for(Pair<Integer, Integer> neigh : adj.get(u)){
                int v = neigh.getKey(), w = neigh.getValue();
                if(dist[u] + w < dist[v]){
                    que.add(v);
                    dist[v] = dist[u] + w;
                }
            }
        } 
        return dist[dest];
    }
    
    
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            if(edge[2] == -1) continue;
            int u =edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        
        
        long dist = dikstra(source, destination, target, n, adj);
        if(dist < target) return new int[0][0];
        if(dist == target){
            for(int[] edge : edges)
                if(edge[2] == -1) edge[2] = 999999999;
            return edges;
        }
        

        
        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            int u = edge[0], v= edge[1], w = edge[2];
            if(w != -1) continue;
            edge[2] = 1;
            adj.get(u).add(new Pair(v, 1));
            adj.get(v).add(new Pair(u, 1));
            
            dist = dikstra(source, destination, target, n, adj);
            if(dist <= target){
                edge[2] += (target-dist);
                for(int j = i+1; j < edges.length; j++)
                    if(edges[j][2] == -1) edges[j][2] = 999999999;
                
                return edges;
            }
        }
        
        return new int[0][0];
    }
}