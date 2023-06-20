class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        // not a single window possible
        if(2l*k + 1 > n) return res;
        
        long leftSum = 0, rightSum = 0;
        for(int i = 0; i < k; i++) leftSum += nums[i];
        for(int i = k+1; i <= 2*k; i++) rightSum += nums[i];
        
        
        for(int i = k; i < n-k; i++){
            long avg = (leftSum + nums[i] + rightSum)/(2l*k+1);
            res[i] = (int)avg;
            if(i == n-k-1) break;
            
            // sliding window 
            leftSum += nums[i] - nums[i-k];
            rightSum += nums[i+k+1] - nums[i+1];
            System.out.println(nums[i+k]);
        }
        
        return res;
    }
}