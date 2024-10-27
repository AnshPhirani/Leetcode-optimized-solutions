class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        int count = 0;
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(matrix[i][j] == 0) continue;
                int min = Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]));
                dp[i][j] = min + 1;
                count += dp[i][j];
            }
        }
        
        return count;
    }
}

// [
//   [0,3,2,1],
//   [1,2,2,1],
//   [0,1,1,1]
// ]



// 2 + 1 + 2 + 1+ 2 + 1 + 3 + 2 + 1  = 15
    