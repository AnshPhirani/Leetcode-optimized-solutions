class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for(int[] flight : flights){
            int from = flight[0], to = flight[1], cost = flight[2];
            adj.get(from).add(new int[]{to, cost});
        }
        
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        
        Queue<int[]> que =  new LinkedList<>();
        que.add(new int[]{src, 0});
        int level = 0;
        
        while(!que.isEmpty() && level <= k){
            int size = que.size();
            while(size-- > 0){
                int curNode = que.peek()[0];
                int curCost = que.poll()[1];
                
                for(int[] neighbour : adj.get(curNode)){
                    int neighNode = neighbour[0];
                    int cost = neighbour[1];
                    if(curCost + cost < minCost[neighNode]){
                        minCost[neighNode] = curCost+cost;
                        que.add(new int[]{neighNode, minCost[neighNode]});
                    }
                }
                
            }
            level++;
        }
        
        return minCost[dst] != Integer.MAX_VALUE ? minCost[dst] : -1;
        
    }
}