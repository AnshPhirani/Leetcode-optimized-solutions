class Solution {

    
    public int[][] updateMatrix(int[][] mat) {        
        int n = mat.length, m = mat[0].length;
        int[][] res = new int[n][m];
        
        for(int[] r : res) Arrays.fill(r, 999999);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0) res[i][j] = 0;
                else{
                    int top = (i-1 >= 0) ? 1 + res[i-1][j] : 999999;
                    int left = (j-1 >= 0) ? 1 + res[i][j-1] : 999999;
                    res[i][j] = Math.min(top, left);
                }
            }
        }
        

        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                int bottom = (i+1 < n) ? 1 + res[i+1][j] : 999999;
                int right = (j+1 < m) ? 1 + res[i][j+1] : 999999;
                res[i][j] = Math.min(res[i][j], Math.min(bottom, right));
            }
        }
        
        
        return res;
    }
}