class Solution {
    
    private double calcDistance(long x1, long y1, long x2, long y2){
        return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
    }
    
    private int bfs(int src, List<List<Integer>> adj){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> que = new LinkedList<>();
        que.add(src);
        visited.add(src);
        
        while(!que.isEmpty()){
            int curBomb = que.poll();
            for(int neighBomb : adj.get(curBomb)){
                if(!visited.contains(neighBomb)){
                    visited.add(neighBomb);
                    que.add(neighBomb);
                }
            }
        }
        
        return visited.size();
        
    }
    
    
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int[] bomb1 = bombs[i];
                int[] bomb2 = bombs[j];
                double dist = calcDistance(bomb1[0], bomb1[1], bomb2[0], bomb2[1]);
                if(bomb1[2] >= dist) adj.get(i).add(j);
                if(bomb2[2] >= dist) adj.get(j).add(i);
            }
        }
        
        int maxBombs = 0;
        for(int i = 0; i < n; i++){
            int curBombs = bfs(i, adj); // detonate i-th bomb
            maxBombs = Math.max(maxBombs, curBombs);
        }
        
        return maxBombs;
        
    }
}