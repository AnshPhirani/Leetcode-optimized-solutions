class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length, m = mat[0].length;
        int[][] prefMatSum = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefMatSum[i][j] = mat[i - 1][j - 1] + prefMatSum[i - 1][j] + prefMatSum[i][j - 1]
                        - prefMatSum[i - 1][j - 1];
            }
        }

        // for(int[] pm : prefMatSum) System.out.println(Arrays.toString(pm));

        int maxSide = 0;
        for (int startRow = 0; startRow < n; startRow++) {
            for (int startCol = 0; startCol < m; startCol++) {
                int maxLen = Math.min(n - startRow, m - startCol);
                for (int len = 1; len <= maxLen; len++) {
                    int totalSum = prefMatSum[startRow + len][startCol + len];
                    int squareSum = totalSum - (prefMatSum[startRow + len][startCol] + prefMatSum[startRow][startCol + len]
                            - prefMatSum[startRow][startCol]);
                    if (squareSum <= threshold) {
                        maxSide = Math.max(maxSide, len);
                    }
                }
            }
        }

        return maxSide;

    }
}

// 300*300
