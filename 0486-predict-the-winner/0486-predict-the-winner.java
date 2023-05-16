class Solution {
    private int[] nums;
    
    Integer[][][] memo;
    
    private int helper(int l, int r, int player){
        if(l > r) return 0;
        if(memo[l][r][player] != null) return memo[l][r][player];
        
        if(player == 0){
            int low = nums[l] + helper(l+1, r, 1-player);
            int high = nums[r] + helper(l, r-1, 1-player);
            return memo[l][r][player] = Math.max(low, high);
        }
        else{
            int low = -nums[l] + helper(l+1, r, 1-player);
            int high = -nums[r] + helper(l, r-1, 1-player);
            return memo[l][r][player] = Math.min(low, high);
        }
    }
    
    public boolean PredictTheWinner(int[] nums) {

        this.nums = nums;
        this.memo = new Integer[nums.length][nums.length][2];
        return helper(0, nums.length-1, 0) >= 0;
    }
}