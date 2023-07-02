class TreeAncestor {
    int[][] sparseTree;
    
    public TreeAncestor(int n, int[] parent) {
        this.sparseTree = new int[n][20];
        for(int[] s : sparseTree) Arrays.fill(s, -1);
        
        for(int i = 0; i < n; i++){
            sparseTree[i][0] = parent[i];
        }
        
        for(int j = 1; j < 20; j++){
            for(int i = 0; i < n; i++){
                if(sparseTree[i][j-1] != -1)
                    sparseTree[i][j] = sparseTree[sparseTree[i][j-1]][j-1];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int kthParent = node;
        int pos = 0;
        while(k > 0 && kthParent != -1){
            if(k%2 != 0) kthParent = sparseTree[kthParent][pos];
            pos++;
            k /= 2;
        }
        return kthParent;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */