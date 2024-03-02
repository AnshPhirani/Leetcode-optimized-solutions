class Solution {
    public int[] sortedSquares(int[] nums) {
        int n  = nums.length;
        
        int pivotIdx = n;
        for(int i = 0; i < n; i++){
            if(nums[i] >= 0){
                pivotIdx = i;
                break;
            }
        }
        
        int[] ans = new int[n];
        int l = pivotIdx-1;
        int r = pivotIdx;
        int idx = 0;
        while(idx < n){
            int first = l >= 0 ? nums[l]*nums[l] : Integer.MAX_VALUE;
            int second = r < n ? nums[r]*nums[r] : Integer.MAX_VALUE;
            if(first <= second){
                ans[idx++] = first;
                l--;
            }
            else{
                ans[idx++] = second;
                r++;
            }
        }
        
        return ans;
        
        
    }
}