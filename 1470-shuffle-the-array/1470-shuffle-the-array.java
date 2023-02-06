class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        int i = 0, j = n;
        
        int idx = 0;
        while(i < n){
            res[idx++] = nums[i++];
            res[idx++] = nums[j++];
        }
        
        return res;
        
    }
}