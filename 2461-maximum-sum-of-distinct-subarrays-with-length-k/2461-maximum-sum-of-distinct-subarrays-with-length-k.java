class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        long curSum = 0;
        long maxSum = 0;
        for(int i = 0; i < n; i++){
            int num = nums[i];
            curSum += num;
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if(i >= k-1){
                if(freq.size() == k) maxSum = Math.max(maxSum, curSum);
                int toRemove = nums[i-k+1];
                freq.put(toRemove, freq.get(toRemove)-1);
                if(freq.get(toRemove) == 0) freq.remove(toRemove);
                curSum -= toRemove;
                
            }
        }
        
        return maxSum;
    }
}