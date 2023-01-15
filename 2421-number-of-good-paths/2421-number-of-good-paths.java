class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
        rank = new int[size];
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union_set(int x, int y) {
        int xset = find(x), yset = find(y);
        if (xset == yset) {
            return;
        } else if (rank[xset] < rank[yset]) {
            parent[xset] = yset;
        } else if (rank[xset] > rank[yset]) {
            parent[yset] = xset;
        } else {
            parent[yset] = xset;
            rank[xset]++;
        }
    }
}


class Solution {
    
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = edges.length+1;
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        TreeMap<Integer, List<Integer>> valuesToNodes = new TreeMap<>();
        for(int i = 0; i < n; i++){
            valuesToNodes.computeIfAbsent(vals[i], V -> new ArrayList<>()).add(i);
        }
        
        UnionFind dsu = new UnionFind(n);
        int goodPaths = 0;
        
        for(int value : valuesToNodes.keySet()){
            
            // adding nodes of same value to subgraph
            for(int node : valuesToNodes.get(value)){
                for(int neighbor : adj.get(node)){
                    if(vals[node] >= vals[neighbor]){
                        dsu.union_set(node, neighbor);
                    }
                }
            }
            
            // counting nodes having value={value} for all components
            Map<Integer, Integer> groups = new HashMap<>();
            for(int node : valuesToNodes.get(value)){
                int representative = dsu.find(node); 
                groups.put(representative, groups.getOrDefault(representative, 0) + 1);
            }
            
            // calculating the number of goods paths for each component
            for(int groupRepresentative : groups.keySet()){
                int freq = groups.get(groupRepresentative);
                goodPaths += freq*(freq+1)/2;
            }
        }
        
        return goodPaths;
        
    }
}