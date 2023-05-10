class Solution {
    public int[][] generateMatrix(int n) {
        int rs = 0, re = n-1;
        int cs = 0, ce = n-1;
        
        int[][] matrix = new int[n][n];
        int total = n*n;
        int k = 1;
        
        while(k <= total){
            for(int j = cs; j <= ce && k <= total; j++) matrix[rs][j] = k++;
            rs++;
            for(int i = rs; i <= re && k <= total; i++) matrix[i][ce] = k++;
            ce--;
            for(int j = ce; j >= cs && k <= total; j--) matrix[re][j] = k++;
            re--;
            for(int i = re; i >= rs && k <= total; i--) matrix[i][cs] = k++;
            cs++;
        }
        return matrix;
    }
}