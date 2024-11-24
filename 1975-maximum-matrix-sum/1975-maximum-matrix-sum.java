class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum  = 0;
        int minAbsVal = Integer.MAX_VALUE;
        int negCount = 0;
        for(int[] row : matrix){
            for(int val : row){
                totalSum += Math.abs(val);
                if(val < 0) negCount++;
                minAbsVal = Math.min(minAbsVal, Math.abs(val));
            }
        }
        
        if(negCount%2 != 0) totalSum -= 2 * minAbsVal;
        
        return totalSum;
    }
}