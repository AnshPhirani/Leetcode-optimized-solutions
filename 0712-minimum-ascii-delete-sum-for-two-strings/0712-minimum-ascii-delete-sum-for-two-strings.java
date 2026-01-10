class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                int ch1 = (int)s1.charAt(i-1);
                int ch2 = (int)s2.charAt(j-1);
                if(ch1 == ch2){
                    dp[i][j] = dp[i-1][j-1] + ch1;
                }
                else{
                    dp[i][j] =  Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        int totalAscii = 0;
        for(char ch : s1.toCharArray()) totalAscii += (int)ch;
        for(char ch : s2.toCharArray()) totalAscii += (int)ch;
        return totalAscii - 2*dp[n][m];
    }
}