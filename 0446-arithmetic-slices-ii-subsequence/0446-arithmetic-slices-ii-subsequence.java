class Solution {
    int[] nums;
    int n;

    public int numberOfArithmeticSlices(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        if(n < 3) return 0;
        
        int count = 0;
        
        Map<Integer, Integer>[] dp = new HashMap[n];
        for(int i = 0; i < n; i++) dp[i] = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                long tempDiff = (long)nums[i] - (long)nums[j];
                if(tempDiff < Integer.MIN_VALUE || tempDiff > Integer.MAX_VALUE) continue;
                int diff = (int)tempDiff;
                
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + dp[j].getOrDefault(diff, 0) + 1);
                count += dp[j].getOrDefault(diff, 0);
            }
        }
        
       return count; 
    }
}