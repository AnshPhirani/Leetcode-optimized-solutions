class Solution {
    
    int n, m, k;
    Integer[][][] memo;
    
    private int helper(int idx, int curSearchCost, int prevLargest){
        if(curSearchCost > k) return 0;
        if(idx == n){
            return curSearchCost == k? 1 : 0;
        }
        
        if(memo[idx][curSearchCost][prevLargest] != null)
            return memo[idx][curSearchCost][prevLargest];
        
        
        int ans = 0;
        for(int val = 1; val <= m; val++){
            if(val > prevLargest){
                ans += helper(idx+1, curSearchCost+1, val);
            }
            else{
                ans += helper(idx+1, curSearchCost, prevLargest);
            }
            ans %= (int)1e9+7;
        }
        
        return memo[idx][curSearchCost][prevLargest] = ans;
        
    }
    
    public int numOfArrays(int n, int m, int k) {
        this.n = n;
        this.m = m;
        this.k = k;
        this.memo = new Integer[n][k+1][m+1];
        return helper(0, 0, 0);
        
    }
}