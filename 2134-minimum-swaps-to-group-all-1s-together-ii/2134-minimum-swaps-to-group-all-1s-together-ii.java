class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int oneCount = 0;
        for(int num : nums) if(num == 1) oneCount++;
        
        int ans = n;
        int curOnes = 0;
        int start = 0, end = 0;
        while(end < oneCount){
            if(nums[end++] == 1) curOnes++;
        }
        
        ans = Math.min(ans, oneCount-curOnes);
        
        while(start < n){
            end %= n;
            if(nums[start++] == 1) curOnes--;
            if(nums[end++] == 1) curOnes++;
            ans = Math.min(ans, oneCount - curOnes);
        }
        
        return ans;
        
    }
}