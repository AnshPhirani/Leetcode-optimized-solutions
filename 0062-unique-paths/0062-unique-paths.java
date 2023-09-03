class Solution {
    
    Integer[][] memo = new Integer[101][101];
    
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0) return 0;
        if(m == 1 && n == 1) return 1;
        
        if(memo[m][n] != null) return memo[m][n];
        
        return memo[m][n] = uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }
}