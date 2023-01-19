class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1);
        int prefixSum = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            prefixSum += num;
            prefixSum %= k;
            if(prefixSum < 0) prefixSum += k;

            if(freqMap.containsKey(prefixSum)){
                res += freqMap.get(prefixSum);
            }
            
            freqMap.put(prefixSum, freqMap.getOrDefault(prefixSum, 0) + 1);
        }
        return res;
    }
}