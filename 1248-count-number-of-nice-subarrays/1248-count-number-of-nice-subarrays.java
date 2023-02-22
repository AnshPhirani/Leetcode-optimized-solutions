class Solution {
    
    /* 
    arr = [2,2,2,1,2,2,1,2,2,2]
    pref= [0,0,0,1,1,1,2,2,2,2]
    
    [2,2,2,1,2,2,1,2,2,2,1,1,2,2,1,2]
    [0,0,0,1,1,1,2,2,2,2,3,4,4,4,5,5]
    
    
    */
    
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        if(k > n) return 0;
        
        Map<Integer, Integer> oddCountFreq = new HashMap<>();
        oddCountFreq.put(0, 1);
        
        int prefOddCount = 0;
        int subarrayCount = 0;
        
        for(int i = 0; i < n; i++){
            if(nums[i]%2 != 0) prefOddCount += 1;
            oddCountFreq.put(prefOddCount, oddCountFreq.getOrDefault(prefOddCount, 0)+1);
            subarrayCount += oddCountFreq.getOrDefault(prefOddCount-k, 0);
        }
    
        return subarrayCount;
    }
}