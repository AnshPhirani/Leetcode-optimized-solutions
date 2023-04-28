class Solution {
    
    private boolean isSimilar(String first, String second){
        int diff = 0;
        for(int i = 0; i < first.length(); i++){
            if(first.charAt(i) != second.charAt(i)) diff++;
        }
        return diff == 2 || diff == 0;
    }
    
    private void dfs(int idx, int n, String[] strs, boolean[] visited){
        visited[idx] = true;
        
        for(int i = 0; i < n; i++){
            if(!visited[i] && isSimilar(strs[idx], strs[i])){
                dfs(i, n, strs, visited);
            }
        }
    }
    
    
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        boolean[] visited = new boolean[n];
        
        int components = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, n, strs, visited);
                components++;
            }
        }
        
        return components;
    }
}