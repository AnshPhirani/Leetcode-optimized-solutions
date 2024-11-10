class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        if(k == 0) return 1;
        int n = nums.length;
        
        int minLen = Integer.MAX_VALUE;;
        int curOR = 0;
        int[] bitCounts = new int[32];
        int s = 0, e = 0;
        
        while(e < n){
            updateBitCounts(bitCounts, nums[e], 1);
    
            while(convertBitCountsToNumber(bitCounts) >= k){
                minLen = Math.min(minLen, e-s+1);
                updateBitCounts(bitCounts, nums[s], -1);
                s++;
            }
            
            e++;
        }
        
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    } 
    
    
    // Updates bit count array when adding/removing a number from window
    private void updateBitCounts(int[] bitCounts, int number, int delta) {
        for (int bitPosition = 0; bitPosition < 32; bitPosition++) {
            // Check if bit is set at current position
            if (((number >> bitPosition) & 1) != 0) {
                bitCounts[bitPosition] += delta;
            }
        }
    }

    // Converts bit count array back to number using OR operation
    private int convertBitCountsToNumber(int[] bitCounts) {
        int result = 0;
        for (int bitPosition = 0; bitPosition < 32; bitPosition++) {
            if (bitCounts[bitPosition] != 0) {
                result |= 1 << bitPosition;
            }
        }
        return result;
    }
    
}