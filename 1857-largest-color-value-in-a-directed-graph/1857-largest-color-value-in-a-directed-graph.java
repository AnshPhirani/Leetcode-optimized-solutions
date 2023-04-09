class Solution {

 
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[][] count = new int[n][26];
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        int[] inDegree = new int[n];
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; i++)
            if(inDegree[i] == 0) que.add(i);
        
        int maxColorFreq = 0;
        int nodesProcessed = 0;
        while(!que.isEmpty()){
            int u = que.poll();
            count[u][colors.charAt(u) - 'a']++;
            maxColorFreq = Math.max(maxColorFreq, count[u][colors.charAt(u)-'a']);
            
            for(int v : adj.get(u)){
                for(int i = 0; i < 26; i++)
                    count[v][i] = Math.max(count[v][i], count[u][i]);
                
                inDegree[v]--;
                if(inDegree[v] == 0) que.add(v);
            }
            nodesProcessed++;
        }
        
        return nodesProcessed == n ? maxColorFreq : -1;
        
    }
}