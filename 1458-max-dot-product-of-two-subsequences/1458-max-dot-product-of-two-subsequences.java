class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        for(int[] d : dp) Arrays.fill(d, Integer.MIN_VALUE);

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                int prod = nums1[i-1] * nums2[j-1];

                // include both current elements in subseq
                if(prod >= 0) dp[i][j] = Math.max(prod, prod + dp[i-1][j-1]);
                else dp[i][j] = prod;

                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }

        for(int[] d : dp) System.out.println(Arrays.toString(d));

        return dp[n][m];
    }   
}