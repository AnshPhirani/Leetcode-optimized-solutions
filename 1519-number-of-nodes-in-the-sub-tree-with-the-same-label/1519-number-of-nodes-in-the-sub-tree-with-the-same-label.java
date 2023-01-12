class Solution {
    List<List<Integer>> adj;
    String labels;
    Map<Character, Integer> labelCount;
    int[] res;
    int n;
    
    private int[] dfs(int u, int parent){
        
        int[] curLabelCount = new int[26];
        
        for(int v : adj.get(u)){
            if(v == parent) continue;
            
            int[] childLabelCount = dfs(v, u);
            for(int i = 0; i < 26; i++){
                curLabelCount[i] += childLabelCount[i];
            }
        }
        
        char curLabel = labels.charAt(u);
        curLabelCount[curLabel-'a']++;
        res[u] = curLabelCount[curLabel-'a'];
        
        return curLabelCount;
    }
    
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.labels = labels;
        this.adj = new ArrayList<>();
        this.labelCount = new HashMap<>();
        this.res = new int[n];
        this.n = n;
        
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        
        dfs(0, -1);
        return res;
    }
}