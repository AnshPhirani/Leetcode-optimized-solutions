class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        
        // building 2D prefix matrix
        for(int i = 0; i < n; i++){
            for(int j = 1; j < m; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        
        int count = 0;
        
        for(int col1 = 0; col1 < m; col1++){
            for(int col2 = col1; col2 < m; col2++){
                Map<Integer, Integer> freq = new HashMap<>();
                int sum = 0;
                freq.put(0, 1);
                for(int row = 0; row < n; row++){
                    sum += matrix[row][col2] - (col1-1 >= 0 ? matrix[row][col1-1] : 0);
                    if(freq.containsKey(sum-target)){
                        count += freq.get(sum-target);
                    }
                    freq.put(sum, freq.getOrDefault(sum, 0) + 1);
                }
            }
        }
        
        return count;
        
    }
}