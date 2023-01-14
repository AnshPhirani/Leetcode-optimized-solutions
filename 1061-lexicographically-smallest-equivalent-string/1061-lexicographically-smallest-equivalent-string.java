class Solution {
    Map<Integer, Set<Integer>> adj;
    
    private int dfs(int u, boolean[] visited, Set<Integer> nodes){
        if(visited[u]) return 999999;
        
        visited[u] = true;
        nodes.add(u);
        
        int minChar = u;
        for(int v : adj.get(u)){
            int childMinChar = dfs(v, visited, nodes);
            minChar = Math.min(minChar, childMinChar);
        }
        
        return minChar;
    }
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        adj = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            char u = s1.charAt(i);
            char v = s2.charAt(i);
            adj.computeIfAbsent(u-'a', (V) -> new HashSet<>()).add(v-'a');
            adj.computeIfAbsent(v-'a', (V) -> new HashSet<>()).add(u-'a');
        }
        
        Map<Integer, Integer> charToMinChar = new HashMap<>();
        
        boolean[] visited = new boolean[26];
        for(int u : adj.keySet()){
            if(visited[u]) continue;
            
            Set<Integer> nodes = new HashSet<>();
            int minChar = dfs(u, visited, nodes);
            for(int node : nodes){
                charToMinChar.put(node, minChar);
            }
        }
        
        String res = "";
        for(char ch : baseStr.toCharArray()){
            int minChar = charToMinChar.getOrDefault(ch-'a', ch-'a');
            res += (char)(minChar + 'a');
        }
        return res;
    }
}