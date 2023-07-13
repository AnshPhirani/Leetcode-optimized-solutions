class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        int[] inDegree = new int[n];
        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }
        
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; i++)
            if(inDegree[i] == 0) que.add(i);
        
        int nodeProcessed = 0;
        while(!que.isEmpty()){
            int cur = que.poll();
            for(int neigh : adj.get(cur)){
                inDegree[neigh]--;
                if(inDegree[neigh] == 0) que.add(neigh);
            }
            nodeProcessed++;
        }
        
        return nodeProcessed == n;
    }
}