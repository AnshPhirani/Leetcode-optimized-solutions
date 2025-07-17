class Solution {
    public int maximumLength(int[] nums) {
        int ans = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i]%2 !=  nums[i-1]%2) ans++;
        }

        int evenCount = 0, oddCount = 0;
        for(int num : nums){
            if(num%2 == 0) evenCount++;
            else oddCount++;
        }

        return Math.max(ans, Math.max(evenCount, oddCount));
    }
}