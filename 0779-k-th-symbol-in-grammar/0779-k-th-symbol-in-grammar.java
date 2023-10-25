class Solution {
    
    private int dfs(int rootVal, int n, int k){
        if(n == 1) return rootVal;
        
        int totalNodes = (1<<(n-1));
        
        if(k > totalNodes/2){
            return dfs(1-rootVal, n-1, k-totalNodes/2);
        }
        else{
            return dfs(rootVal, n-1, k);
        }
    }
    
    public int kthGrammar(int n, int k) {
        return dfs(0, n, k);
    }
}