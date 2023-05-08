class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int pDiagonal = 0, sDiagonal = 0;
        
        for(int i = 0; i < n; i++){
            pDiagonal += mat[i][i];
            sDiagonal += mat[i][n-i-1];
        }
        
        if(n%2 != 0) sDiagonal -= mat[n/2][n/2];
        
        return pDiagonal + sDiagonal;
        
    }
}