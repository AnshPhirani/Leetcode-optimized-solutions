class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        
        int xor = 0;
        int mask = (1<<maximumBit) - 1;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            xor ^= nums[i];
            ans[n-i-1] = xor^mask;
        }
        
        return ans;
    }
}


// 2^3 = 8
// 111

// 010 -> 5
// 001 -> 6
// 101 -> 2
// 010 -> 5

    