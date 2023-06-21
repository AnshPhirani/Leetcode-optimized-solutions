class Solution {
    
    private long getCost(int[] nums, int[] cost, int base){
        long totalCost = 0;
        for(int i = 0; i < nums.length; i++){
            long gap = Math.abs(nums[i] - base);
            totalCost += gap * cost[i];
        }
        return totalCost;
    }
    
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        
        int low = Arrays.stream(nums).min().getAsInt();
        int high = Arrays.stream(nums).max().getAsInt();
        
        long ans = getCost(nums, cost, nums[0]);
        
        while(low < high){
            int mid = low + (high-low)/2;
            long cost1 = getCost(nums, cost, mid);
            long cost2 = getCost(nums, cost, mid+1);
            ans = Math.min(cost1, cost2);
            
            if(cost1 > cost2){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }

        return ans;
    }
}