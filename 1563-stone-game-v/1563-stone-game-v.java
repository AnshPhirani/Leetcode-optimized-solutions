class Solution {
    
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[][] dp = new int[n][n];
        
        int[] prefixSum = new int[n+1];
        prefixSum[0] = 0;
        for(int i = 1; i <= n; i++){
            prefixSum[i] = prefixSum[i-1] + stoneValue[i-1];
        }
        
        for(int g = 0; g < n; g++){
            for(int s = 0; s < n-g; s++){
                int e = s+g;
                if(g == 0){
                    dp[s][e] = 0;
                    continue;
                }
                
                int ans = 0;
                for(int mid = s; mid < e; mid++){
                    int left = prefixSum[mid+1]-prefixSum[s];
                    int right = prefixSum[e+1]-prefixSum[mid+1];
                    if(left > right){
                        ans = Math.max(ans, right+dp[mid+1][e]);
                    }
                    else if(right > left){
                        ans = Math.max(ans, left+dp[s][mid]);
                    }
                    else{
                        ans = Math.max(ans, left + Math.max(dp[s][mid], dp[mid+1][e]));
                    }
                }
                dp[s][e] = ans;
            }
        }
        
        return dp[0][n-1];
        
    }
}