class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternFreq = new HashMap<>();
        for(int[] row : matrix){
            StringBuilder curPattern = new StringBuilder("");
            for(int i = 0; i < row.length; i++){
                if(row[i] == row[0]) curPattern.append('0');
                else curPattern.append('1');
            }
            String curP = curPattern.toString();
            patternFreq.put(curP, patternFreq.getOrDefault(curP, 0) + 1);
        }
        
        int maxRows = 1;
        for(int freq : patternFreq.values()){
            maxRows = Math.max(maxRows, freq);
        }
        return maxRows;
        
    }
}