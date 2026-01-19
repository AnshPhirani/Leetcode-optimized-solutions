class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length, m = mat[0].length;
        int[][] prefMatSum = new int[n+1][m+1];

        // Build prefix sum matrix
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                prefMatSum[i][j] = mat[i-1][j-1] + prefMatSum[i-1][j] + prefMatSum[i][j-1] - prefMatSum[i-1][j-1];
            }
        }

        int maxSide = 0;
        for(int startRow = 0; startRow < n; startRow++){
            for(int startCol = 0; startCol < m; startCol++){
                int maxLen = Math.min(n-startRow, m-startCol);
                for(int len = 1; len <= maxLen; len++){
                    // Correct formula for square sum:
                    // Sum from (startRow, startCol) to (startRow+len-1, startCol+len-1)
                    int squareSum = prefMatSum[startRow+len][startCol+len] 
                                  - prefMatSum[startRow][startCol+len]      // subtract top rectangle
                                  - prefMatSum[startRow+len][startCol]      // subtract left rectangle
                                  + prefMatSum[startRow][startCol];          // add back top-left corner
                    
                    if(squareSum <= threshold){
                        maxSide = Math.max(maxSide, len);
                    } else {
                        // Optimization: if current len exceeds threshold, larger squares will also exceed
                        break;
                    }
                }
            }
        }

        return maxSide;
    }
}
