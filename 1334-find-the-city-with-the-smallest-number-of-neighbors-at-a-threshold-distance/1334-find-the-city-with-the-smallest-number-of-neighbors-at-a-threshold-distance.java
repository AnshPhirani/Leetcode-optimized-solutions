class Solution {
    
//     private int dfs(int src, int parent, List<List<int[]>> adj, int distanceThreshold, boolean[] visited){
//         if(distanceThreshold < 0) return 0;
        
//         int count = 0;
//         if(!visited[src]) count++;
//         visited[src] = true;
        
//         for(int[] neigh : adj.get(src)){
//             int dest = neigh[0], weight = neigh[1];
//             if(dest == src) continue;
//             count += dfs(dest, src, adj, distanceThreshold-weight, visited);
//         }

//         return count;
//     }
    
    
    private static int getFewestReachableCities(int src, int n, List<List<int[]>> adj, int distanceThreshold){
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        Queue<Integer> que = new LinkedList<>();
        que.add(src);
        while(!que.isEmpty()){
            src = que.poll();
            for(int[] neigh : adj.get(src)){
                int dest = neigh[0], weight = neigh[1];
                if(dist[src] + weight < dist[dest]){
                    dist[dest] = dist[src] + weight;
                    que.add(dest);
                }
            }  
        }
        
        int count = 0;
        for(int d : dist){
            if(d <= distanceThreshold) count++;
        }
        return count;
    }
    
    
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0], v = edge[1], weight = edge[2];
            adj.get(u).add(new int[]{v, weight});
            adj.get(v).add(new int[]{u, weight});
        }
        
        int minCities = n+1;
        int ans = -1;
        
        for(int i = 0; i < n; i++){
            int curCities = getFewestReachableCities(i, n, adj, distanceThreshold);
            if(curCities <= minCities){
                ans = i;
                minCities = curCities;
            }
        }
        
        return ans;
    }
}


// Approach 1
    
// for every city we will calc reachable cities
// then sorting by city reachable_count, city_number

// (n * n) + (n*logn)
    
// Approach 2

// remove edges 