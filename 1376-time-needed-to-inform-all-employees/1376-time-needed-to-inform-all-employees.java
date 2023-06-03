class Solution {
    
    private int dfs(int src, List<List<Integer>> adj, int[] informTime){
        int curTime = 0;
        for(int neigh : adj.get(src)){
            curTime = Math.max(curTime, dfs(neigh, adj, informTime));
        }
        return informTime[src] + curTime;
    }
    
    public int numOfMinutes(int n, int headId, int[] manager, int[] informTime) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for(int i = 0; i < n; i++){
            if(i == headId) continue;
            adj.get(manager[i]).add(i);
        }
        
//         Queue<Integer> que = new LinkedList<>();
//         que.add(headId);
//         int totalTime = 0;
//         while(!que.isEmpty()){
//             int size = que.size();
//             int curTime = 0;
//             while(size-- > 0){
//                 int cur = que.poll();
//                 curTime = Math.max()
//             }
            
//         }
        
        return dfs(headId, adj, informTime);
    }
}