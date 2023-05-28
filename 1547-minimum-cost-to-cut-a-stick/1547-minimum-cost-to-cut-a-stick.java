class Solution {
    
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        
        // building newCuts array
        int[] newCuts = new int[cuts.length+2];
        newCuts[0] = 0;
        for(int i = 1; i <= cuts.length; i++) newCuts[i] = cuts[i-1];
        newCuts[newCuts.length-1] = n;
        
        int m = newCuts.length;
        
        int[][] dp = new int[m][m];
        for(int g = 2; g < m; g++){
            for(int s = 0; s < m-g; s++){
                int e = s+g;
                int ans = Integer.MAX_VALUE;
                for(int k = s+1; k < e; k++){
                    ans = Math.min(ans, dp[s][k] + dp[k][e] + newCuts[e]-newCuts[s]);
                }
                dp[s][e] = ans;
            }
        }
        
        
        return dp[0][m-1];
    }
}