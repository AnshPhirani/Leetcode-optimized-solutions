class Solution {
    
    private int[] bfs(int src, int[] edges, int n){
        
        int[] minDistance = new int[n];
        Arrays.fill(minDistance, -1);
        
        Queue<Integer> que = new LinkedList<>();
        que.add(src);
        int distance = 0;
        
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int curNode = que.poll();
                if(minDistance[curNode] == -1){
                    minDistance[curNode] = distance;
                    if(edges[curNode] != -1) que.add(edges[curNode]);
                }
            }
            distance++;
        }
        
        return minDistance;
    }
    
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        
        int[] minDistance1 = bfs(node1, edges, n);
        int[] minDistance2 = bfs(node2, edges, n);
        
        int res = Integer.MAX_VALUE;
        int idx = -1;
        for(int i = 0; i < n; i++){
            int d1 = minDistance1[i];
            int d2 = minDistance2[i];
            if(d1 != -1 && d2 != -1 && Math.max(d1, d2) < res){
                res = Math.max(d1, d2);
                idx = i;
            }
        }
        return idx;
        
    }
}