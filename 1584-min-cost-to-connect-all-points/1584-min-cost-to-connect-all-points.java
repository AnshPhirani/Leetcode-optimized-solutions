class UnionFind{
    int[] parent;
    public UnionFind(int size){
        // this.size = size;
        this.parent = new int[size];
        for(int i = 0; i < size; i++){
            parent[i] = i;
        }
    }
    
    public int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public boolean union(int x, int y){
        int xParent = find(x);
        int yParent = find(y);
        if(xParent == yParent) return false;
        
        parent[xParent] = yParent;
        return true;
    }
    
}

class Solution {
    
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        
        int[][] edges = new int[n*(n-1)/2][3];
        int k = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int dist = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges[k++] = new int[]{i, j, dist};
            }
        }
        
        Arrays.sort(edges, (a, b) -> a[2]-b[2]);
        
        UnionFind uf = new UnionFind(n);
        int edgesUsed = 0;
        int idx = 0;
        int minCost = 0;
        while(edgesUsed < n-1){
            int[] curEdge = edges[idx++];
            int x = curEdge[0], y = curEdge[1], dist = curEdge[2];
            
            if(!uf.union(x, y)) continue;
            minCost += dist;
            edgesUsed++;
        }
        
        return minCost;
    }
}