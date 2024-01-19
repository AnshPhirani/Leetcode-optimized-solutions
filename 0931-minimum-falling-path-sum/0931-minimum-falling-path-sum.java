class Solution {
    
    Integer[][] memo;
    
    private int helper(int i, int j, int[][] matrix){
        if(i == matrix.length) return 0;
        if(j < 0 || j >= matrix[0].length) return 9999999;
        
        if(memo[i][j] != null) return memo[i][j];
        
        int below = helper(i+1, j, matrix);
        int left = helper(i+1, j-1, matrix);
        int right = helper(i+1, j+1, matrix);
        
        return memo[i][j] = matrix[i][j] + Math.min(below, Math.min(left, right));
    }
    
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        this.memo = new Integer[matrix.length][matrix[0].length];
        for(int j = 0; j < matrix[0].length; j++){
            ans = Math.min(ans, helper(0, j, matrix));
        }
        return ans;
    }
}