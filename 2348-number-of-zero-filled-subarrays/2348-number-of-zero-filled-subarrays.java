class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long consecutiveZeros = 0;
        long totalSubarray = 0;
        
        for(int num : nums){
            if(num == 0){
                consecutiveZeros++;
            }
            else{
                totalSubarray += consecutiveZeros * (consecutiveZeros + 1)/2;        
                consecutiveZeros = 0;
            }
        }
        
        totalSubarray += consecutiveZeros * (consecutiveZeros + 1)/2;
        return totalSubarray;
        
    }
}