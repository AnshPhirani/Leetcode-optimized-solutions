class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        int[] inDegree = new int[n];
        for(int[] rel : relations){
            int u = rel[0]-1, v = rel[1]-1;
            adj[u].add(v);
            inDegree[v]++;
        }
        
        int[] timeToReach = new int[n];
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                timeToReach[i] = time[i];
                que.add(i);
            }
        }
        
        while(!que.isEmpty()){
            int src = que.poll();
            for(int neigh : adj[src]){
                if(timeToReach[neigh] < timeToReach[src] + time[neigh]){
                    timeToReach[neigh] = timeToReach[src] + time[neigh];
                }
                inDegree[neigh]--;
                if(inDegree[neigh] == 0) que.add(neigh);
            }
        }
        
        return Arrays.stream(timeToReach).max().getAsInt();
    }
}