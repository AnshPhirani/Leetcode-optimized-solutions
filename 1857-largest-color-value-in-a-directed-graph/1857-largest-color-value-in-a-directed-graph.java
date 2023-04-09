// Map<Node, int[26]> memo;
// {
//    1 -> [b-1]
//    4 -> [a-1]
//    3 -> [a-1 c-1]
//    2 -> a-2 c-1
//    0 -> [a-3 c-1]
// }

// ans = 3;

// [a-1 c-1]   
// 0 -  


class Solution {
    
    Map<Integer, int[]> memo;
    List<List<Integer>> adj;
    boolean hasCycle;
    
    private void dfs(int u, String colors, boolean[] visited){
        
        if(visited[u]){
            hasCycle = true;
            return;
        }
        visited[u] = true;
        
        int[] curFreq = new int[26];
        
        for(int v : adj.get(u)){
            if(!memo.containsKey(v)) dfs(v, colors, visited);
            
            int[] nextFreq = memo.get(v) == null ? new int[26] : memo.get(v);
            for(int i = 0; i < 26; i++){
                curFreq[i] = Math.max(curFreq[i], nextFreq[i]);
            }
        }
        
        visited[u] = false;
        curFreq[colors.charAt(u) - 'a']++;
        memo.put(u, curFreq);
    }
    
    
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        this.memo = new HashMap<>();
        this.adj = new ArrayList<>();
        this.hasCycle = false;
        
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        
        for(int i = 0; i < n; i++){
            if(!memo.containsKey(i)) dfs(i, colors, new boolean[n]);
            if(hasCycle) return -1;
        }
        
        
        int maxColor = 0;
        for(int nodeVal : memo.keySet()){
            for(int colorCount : memo.get(nodeVal))
                maxColor = Math.max(maxColor, colorCount);
        }
        
        return maxColor;
        
    }
}