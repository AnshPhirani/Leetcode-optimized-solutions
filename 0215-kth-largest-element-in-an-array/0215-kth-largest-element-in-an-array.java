class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] freq = new int[2*10000 + 1];
        for(int num : nums) freq[num+10000]++;
        
        for(int num = freq.length-1; num >= 0; num--){
            if(freq[num] >= k) return num-10000;
            else k -= freq[num];
        }
        
        return -1;
    }
}