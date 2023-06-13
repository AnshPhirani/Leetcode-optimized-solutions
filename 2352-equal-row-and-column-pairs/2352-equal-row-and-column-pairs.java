class Solution {
    
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        
        Map<String, Integer> freqMap = new HashMap<>();
        int count = 0;
        
        for(int r = 0; r < n; r++){
            String rowString = Arrays.toString(grid[r]);
            freqMap.put(rowString, freqMap.getOrDefault(rowString, 0)+1);
        }
        
        
        for(int c = 0; c < n; c++){
            int[] col = new int[n];
            for(int r = 0; r < n; r++){
                col[r] = grid[r][c];
            }
            String colString = Arrays.toString(col);
            count += freqMap.getOrDefault(colString, 0);
        }
        
        
        return count;
        
    }
}