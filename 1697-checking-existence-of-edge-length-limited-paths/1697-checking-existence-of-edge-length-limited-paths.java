class UnionFind{
    int[] group, rank;
    
    public UnionFind(int n){
        this.group = new int[n];
        this.rank = new int[n];
        for(int i = 0; i < n; i++) group[i] = i;
    }
    
    public int find(int node){
        if(group[node] == node) return node;
        return group[node] = find(group[node]);
    }
    
    
    public void union(int node1, int node2){
        int group1 = find(node1);
        int group2 = find(node2);
        if(group1 == group2) return;
        
        if(rank[group1] > rank[group2]){
            group[group2] = group1;
        }
        else if(rank[group2] > rank[group1]){
            group[group1] = group2;
        }
        else{
            group[group1] = group2;
            rank[group2] += 1;
        }
    }
    
    public boolean areConnnected(int node1, int node2){
        int group1 = find(node1);
        int group2 = find(node2);
        return group1 == group2;
    }
}

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        UnionFind uf = new UnionFind(n);
        int queriesCount = queries.length;
        boolean[] ans = new boolean[queriesCount];
        
        // Store original indices with all queries.
        int[][] queriesWithIndex = new int[queriesCount][4];
        for (int i = 0; i < queriesCount; ++i) {
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = queries[i][2];
            queriesWithIndex[i][3] = i;
        }
        
        Arrays.sort(queriesWithIndex, (a, b) -> a[2] - b[2]);
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        
        int edgeIndex = 0;
        for(int[] query : queriesWithIndex){
            int p = query[0];
            int q = query[1];
            int limit = query[2];
            int queryOriginalIndex = query[3]; 
            while(edgeIndex < edgeList.length && edgeList[edgeIndex][2] < limit){
                int node1 = edgeList[edgeIndex][0];
                int node2 = edgeList[edgeIndex][1];
                uf.union(node1, node2);
                edgeIndex++;
            }
            ans[queryOriginalIndex] = uf.areConnnected(p, q);
        }
        
        return ans;
    }
}