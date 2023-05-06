class Solution {
    private static final int MOD = (int)1e9 + 7;
    
    private long power(int x, int y){
        if(y == 0) return 1;
        if(y == 1) return x;
        
        long temp = power(x, y/2);
        if(y%2 == 0) return (temp%MOD * temp%MOD)%MOD;
        else return (temp%MOD * temp%MOD * x)%MOD;
    }
    
    private int lowerBound(int[] nums, int target){
        int l = 0, r = nums.length-1;
        int res = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] <= target){
                res = mid;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        
        return res;
    }
    
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        
        long res = 0;
        for(int i = 0; i < n; i++){
            int comp = target - nums[i];
            int compIdx = lowerBound(nums, comp);
            if(compIdx >= i){
                res += power(2, compIdx-i);
                res %= MOD;
            }
        }
        
        return (int)(res%MOD);
    }
}