class Solution {
    public int maximumScore(int[] nums, int k) {
        int i = k, j = k;
        int curMin = nums[k];
        int maxScore = nums[k];
    
        while(i-1 >= 0 || j+1 < nums.length){
            int left = (i-1 >= 0) ? nums[i-1] : Integer.MIN_VALUE;
            int right = (j+1 < nums.length) ? nums[j+1] : Integer.MIN_VALUE;
            if(left <= right){
                j++;
                curMin = Math.min(curMin, nums[j]);
            }
            else{
                i--;
                curMin = Math.min(curMin, nums[i]);
            }
            maxScore = Math.max(maxScore, (j-i+1)*curMin);
        }
        
        return maxScore;
        
    }
}