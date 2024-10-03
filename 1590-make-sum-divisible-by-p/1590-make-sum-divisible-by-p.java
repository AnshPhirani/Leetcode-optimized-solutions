class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for(int num : nums) sum += num;
        if(sum < p) return -1;
        
        long rem = sum%p;
        if(rem == 0) return 0;
        
        // findind the min subarray with sum equals to rem
        Map<Long, Integer> map = new HashMap<>();
        int minLen = nums.length;
        long preSum = 0;
        map.put(0l, -1);
        for(int i = 0; i < nums.length; i++){
            preSum += nums[i];
            preSum %= p;
            long comp = (preSum-rem+p)%p;
            if(map.containsKey(comp)){
                minLen = Math.min(minLen, i-map.get(comp));
            }
            map.put(preSum, i);
        }
        
        return minLen == nums.length ? -1 : minLen;
    }
}