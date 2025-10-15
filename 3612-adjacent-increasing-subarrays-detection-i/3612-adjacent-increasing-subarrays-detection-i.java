class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if(k == 1) return true;

        for(int i = 0; i < n-2*k+1; i++){
            int j = i+1;
            for(;j < i+k; j++){
                if(nums.get(j) <= nums.get(j-1)) break;
            }
            if(j < i+k) continue;

            j = i+k+1;
            for(;j < i+2*k; j++){
                if(nums.get(j) <= nums.get(j-1)) break;
            }
            if(j == i+2*k) return true;
        }

        return false;
    }
}