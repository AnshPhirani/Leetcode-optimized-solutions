class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
            
        for(int g = 0; g < n; g++){
            for(int start = 0; start < n-g; start++){
                int end = start+g;
                if(start == end){
                    dp[start][end] = 1;
                }
                else if(s.charAt(start) == s.charAt(end)){
                    if(start+1 <= end-1){
                        dp[start][end] = 2 + dp[start+1][end-1];
                    }
                    else{
                        dp[start][end] = 2;
                    }
                }
                else{
                    dp[start][end] = Math.max(dp[start+1][end], dp[start][end-1]);
                }
            }
        }
    
        return dp[0][n-1];
        
    }
}