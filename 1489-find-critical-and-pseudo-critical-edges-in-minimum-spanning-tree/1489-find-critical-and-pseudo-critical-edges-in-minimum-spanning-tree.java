class DSU{
    int[] parent, rank;
    int size, componentCount;
    
    public DSU(int size){
        this.size = size;
        this.componentCount = size;
        this.parent = new int[size];
        this.rank = new int[size];
        for(int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    
    public int findParent(int src){
        if(parent[src] == src) return src;
        return parent[src] = findParent(parent[src]);
    }
    
    public boolean union(int a, int b){   
        int aParent = findParent(a);
        int bParent = findParent(b);
        if(aParent == bParent) return false;
        
        if(rank[aParent] > rank[bParent]){
            parent[bParent] = aParent;
        }
        else if(rank[aParent] < rank[bParent]){
            parent[aParent] = bParent;
        }
        else{
            parent[aParent] = bParent;
            rank[bParent]++;
        }
        componentCount--;
        return true;
    }
}

class Solution {
    
    private int krushkalAlgo(int n, int[][] edges, DSU dsu){
        int mstWeight = 0;
        for(int[] edge : edges){
            int u = edge[0], v = edge[1], edgeWeight = edge[2];
            if(edgeWeight == -1) continue; // edge is deleted
            if(dsu.union(u, v)) mstWeight += edgeWeight;
        }
        
        return mstWeight;
    }
    
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {   
        
        // Add index to edges for tracking
        int m = edges.length;
        int[][] newEdges = new int[m][4];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                newEdges[i][j] = edges[i][j];
            }
            newEdges[i][3] = i;
        }

        Arrays.sort(newEdges, (a, b) -> a[2] - b[2]);

        int mstWeight = krushkalAlgo(n, newEdges, new DSU(n));
        
        Set<Integer> criticalEdges = new HashSet<>();
        for(int[] edge : newEdges){
            int edgeWeight = edge[2];
            edge[2] = -1; // deleting edge
            DSU dsu = new DSU(n);
            int newMstWeight = krushkalAlgo(n, newEdges, dsu);
            if(dsu.componentCount > 1 || newMstWeight > mstWeight) criticalEdges.add(edge[3]);
            edge[2] = edgeWeight;
        }
        
        
        List<Integer> sudoCriticalEdges = new ArrayList<>();
        for(int[] edge : newEdges){
            if(criticalEdges.contains(edge[3])) continue;
            DSU dsu = new DSU(n);
            dsu.union(edge[0], edge[1]);
            int newMstWeight = edge[2] + krushkalAlgo(n, newEdges, dsu);
            if(newMstWeight == mstWeight) sudoCriticalEdges.add(edge[3]);
        }
        
        
        return List.of(new ArrayList<>(criticalEdges), sudoCriticalEdges);
        
    }
}