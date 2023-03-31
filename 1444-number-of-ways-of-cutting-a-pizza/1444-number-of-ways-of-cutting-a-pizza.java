class Solution {
    
    final int mod = 1_000_000_007;
    
    int[][] appleCount;
    String[] pizza;
    Integer[][][] memo;
    
    private int helper(int row, int col, int n, int m, int k){
        if(k == 1) return appleCount[row][col] > 0 ? 1 : 0;
        if(appleCount[row][col] == 0) return 0;
        
        
        if(memo[row][col][k] != null) return memo[row][col][k];
        
        int curAns = 0;
        
        // cut horizontally
        for(int i = row+1; i < n; i++){
            if(appleCount[row][col] - appleCount[i][col] > 0){
                curAns += helper(i, col, n, m, k-1);
                curAns %= mod;
            }
        }
        
        // cut vertically
        for(int j = col+1; j < m; j++){
            if(appleCount[row][col] - appleCount[row][j] > 0){
                curAns += helper(row, j, n, m, k-1);
                curAns %= mod;
            }
        }
        
        return memo[row][col][k] = curAns%mod;
    }
    
    public int ways(String[] pizza, int k) {
        int n = pizza.length;
        int m = pizza[0].length();
        
        this.pizza = pizza;
        this.appleCount = new int[n+1][m+1];
        this.memo = new Integer[n][m][k+1];
        
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                appleCount[i][j] = appleCount[i+1][j] + appleCount[i][j+1] - appleCount[i+1][j+1];
                appleCount[i][j] += (pizza[i].charAt(j) == 'A') ?  1 : 0;
            }
        }
        
        return helper(0, 0, n, m, k);
    }
}