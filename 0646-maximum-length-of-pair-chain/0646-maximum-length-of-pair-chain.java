class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> a[0]-b[0]);
        
        // find LIS
        int maxLen = 0;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = i-1; j >= 0; j--){
                if(pairs[j][1] < pairs[i][0])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return maxLen;
    }
}