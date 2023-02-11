class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Set<Integer>[][] adj = new HashSet[2][n];
        // adj[0] represents graph with red edges and adj[1] graph with blue edges
        
        for(int i = 0; i < n; i++){
            adj[0][i] = new HashSet<>();
            adj[1][i] = new HashSet<>();
        }
        
        for(int[] redEdge : redEdges){
            adj[0][redEdge[0]].add(redEdge[1]);
        }
        
        for(int[] blueEdge : blueEdges){
            adj[1][blueEdge[0]].add(blueEdge[1]);
        }
        
        int[][] distance = new int[2][n];
        for(int i = 1; i < n; i++){
            distance[0][i] = Integer.MAX_VALUE;
            distance[1][i] = Integer.MAX_VALUE;
        }
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0}); 
        que.add(new int[]{0, 1});
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int u = cur[0], color = cur[1];
            
            for(int v : adj[1-color][u]){
                if(distance[1-color][v] == Integer.MAX_VALUE){
                    distance[1-color][v] = distance[color][u] + 1;
                    que.add(new int[]{v, 1-color});
                }
            }    
        }
        
        int[] res = new int[n];
        for(int i = 1; i < n; i++){
            res[i] = Math.min(distance[0][i], distance[1][i]);
            if(res[i] == Integer.MAX_VALUE) res[i] = -1;
        }
        return res;
        
        
    }
}