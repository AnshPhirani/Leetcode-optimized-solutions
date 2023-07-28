class Solution {
    
    private int helper(int s, int e, int[] nums){
        if(s > e) return 0;
        
        int pickFirst = nums[s] - helper(s+1, e, nums);
        int pickLast = nums[e] - helper(s, e-1, nums);
        return Math.max(pickFirst, pickLast);
        
    }
    
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length%2 == 0) return true;
        int player1Score = helper(0, nums.length-1, nums);
        return player1Score >= 0;
    }
}