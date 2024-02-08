class Solution {
    
    Integer[] memo = new Integer[10001];
    
    public int numSquares(int n) {
        if(n <= 1) return n;
        
        if(memo[n] != null) return memo[n];
        
        int ans = 999999999;
        for(int i = 1; i*i <= n; i++){
            ans = Math.min(ans, 1 + numSquares(n-i*i));
        }
        
        return memo[n] = ans;
    }
}