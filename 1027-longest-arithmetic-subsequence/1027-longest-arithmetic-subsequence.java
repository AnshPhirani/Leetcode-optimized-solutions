class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for(int i = 0; i < n; i++) dp[i] = new HashMap<>();
        
        int maxLen = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int secondLast = nums[i], last = nums[j];
                int diff = last-secondLast;
                dp[j].put(diff, dp[i].getOrDefault(diff, 1) + 1);
                maxLen = Math.max(maxLen, dp[j].get(diff));
            }
        }
        
        return maxLen;
    }
}