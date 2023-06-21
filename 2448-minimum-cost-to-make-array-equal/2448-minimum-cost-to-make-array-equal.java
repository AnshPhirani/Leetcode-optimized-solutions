class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] numsAndCost = new int[n][2];
        for(int i = 0; i < n; i++){
            numsAndCost[i][0] = nums[i];
            numsAndCost[i][1] = cost[i];
        }
        Arrays.sort(numsAndCost, (a, b) -> a[0]-b[0]);
        
        long[] prefixCost = new long[n];
        prefixCost[0] = numsAndCost[0][1];
        for(int i = 1; i < n; i++){
            prefixCost[i] = prefixCost[i-1] + numsAndCost[i][1];
        }
        
        long totalCost = 0;
        for(int i = 1; i < n; i++){
            long gap = numsAndCost[i][0]-numsAndCost[0][0];
            totalCost += gap * numsAndCost[i][1];
        }
        
        long ans = totalCost;
        
        for(int i = 1; i < n; i++){
            long gap = numsAndCost[i][0] - numsAndCost[i-1][0];
            totalCost += gap * prefixCost[i-1];
            totalCost -= gap * (prefixCost[n-1] - prefixCost[i-1]);
            ans = Math.min(ans, totalCost);
        }
        
        return ans;
        
    }
}