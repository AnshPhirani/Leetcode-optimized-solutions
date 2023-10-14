class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        
        int[] suffixMin = new int[n];
        suffixMin[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            suffixMin[i] = Math.min(suffixMin[i+1], nums[i]);
        }
        
        for(int i = 0; i < n-2; i++){
            if(suffixMin[i+2] < nums[i]) return false;
        }
        
        return true;
    }
}