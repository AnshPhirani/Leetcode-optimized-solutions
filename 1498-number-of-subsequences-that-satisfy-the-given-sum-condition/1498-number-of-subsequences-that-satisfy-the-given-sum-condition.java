class Solution {
    private static final int MOD = (int)1e9 + 7;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        
        int[] power = new int[n];
        power[0] = 1;
        for(int i = 1; i < n; i++){
            power[i] = (2*power[i-1])%MOD;
        }
            
        int res = 0;
        int left = 0, right = n-1;
        while(left <= right){
            if(nums[left]+nums[right] <= target){
                res += power[right-left];
                res %= MOD;
                left++;
            }
            else{
                right--;
            }
        }
        
        return res%MOD;
    }
}