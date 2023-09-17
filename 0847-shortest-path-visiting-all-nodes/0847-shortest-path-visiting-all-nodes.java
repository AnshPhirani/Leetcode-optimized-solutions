class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        
        // {node, dist, mask}
        Queue<int[]> que = new LinkedList<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        int targetMask = (1<<n)-1;
        for(int i = 0; i < n; i++){
            que.add(new int[]{i, 0, (1<<i)});
            visited.add(new Pair(i, (1<<i)));
        }
       
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int curNode = cur[0], curDist = cur[1], curMask = cur[2];
            if(curMask == targetMask) return curDist;
            
            for(int neigh : graph[curNode]){
                int newMask = curMask | (1<<neigh);
                if(visited.contains(new Pair(neigh, newMask))) continue;
                que.add(new int[]{neigh, curDist+1, newMask});
                visited.add(new Pair(neigh, newMask));
            }
        }
        
        return -1; 
    }
}