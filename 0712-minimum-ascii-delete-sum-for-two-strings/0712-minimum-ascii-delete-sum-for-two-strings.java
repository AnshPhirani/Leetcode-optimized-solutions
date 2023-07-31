class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        
        int[][] dp = new int[n+1][m+1];
        for(int i = n; i >= 0; i--){
            for(int j = m; j >= 0; j--){
                if(i == n || j == m){
                    if(i == n && j == m) dp[i][j] = 0;
                    else if(i == n) dp[i][j] = s2.charAt(j) + dp[i][j+1];
                    else dp[i][j] = s1.charAt(i) + dp[i+1][j];
                }
                else if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }
                else{
                    int deleteBoth = s1.charAt(i) + s2.charAt(j) + dp[i+1][j+1];
                    int deleteFirst = s1.charAt(i) + dp[i+1][j];
                    int deleteSecond = s2.charAt(j) + dp[i][j+1];
                    dp[i][j] = Math.min(deleteBoth, Math.min(deleteFirst, deleteSecond));
                }
            }
        }
        
        return dp[0][0];
    }
}