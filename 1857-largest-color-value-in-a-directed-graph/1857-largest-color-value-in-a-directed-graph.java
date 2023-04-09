
// {
    
// }


// 2 -> 3 -> 4

//     9 -> 10 -> 6  -> 4
    
// 3 [a-2 c-1] -> 4[a-3 c-1]

// 6 [a-3] -> 4[a-2 c-1]


class Solution {
    
    private Map<Integer, int[]> memo;
    private List<List<Integer>> adj;
 
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        this.memo = new HashMap<>();
        this.adj = new ArrayList<>();
        
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
        Set<Integer> nodesProcessed = new HashSet<>();
        while(!que.isEmpty()){
            int u = que.poll();
            nodesProcessed.add(u);
            if(!memo.containsKey(u)){
                memo.put(u, new int[26]);
                memo.get(u)[colors.charAt(u) - 'a']++;
            }
            int[] curMaxFreq = memo.get(u);
            
            for(int i = 0; i < 26; i++)
                    maxColorFreq = Math.max(maxColorFreq, curMaxFreq[i]);
            
            for(int v : adj.get(u)){
                if(!memo.containsKey(v)){
                    memo.put(v, new int[26]);
                    memo.get(v)[colors.charAt(v) -'a']++;
                }
                
                int[] neighMaxFreq = memo.get(v);
                neighMaxFreq[colors.charAt(v) - 'a']--;
                for(int i = 0; i < 26; i++){
                    neighMaxFreq[i] = Math.max(neighMaxFreq[i], curMaxFreq[i]);
                }
                neighMaxFreq[colors.charAt(v) - 'a']++;
                
                
                inDegree[v]--;
                if(inDegree[v] == 0) que.add(v);
            }
        }
        
        return nodesProcessed.size() == n ? maxColorFreq : -1;
        
    }
}