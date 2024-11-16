class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        if(n == 1 || k == 1) return nums;
        
        int[] ans = new int[n-k+1];
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        int start = 0, end = 0;
        deque.add(end); 
        while(end < n-1){
            if(nums[end+1] == nums[end]+1){
                deque.add(end+1);
            }
            else{
                deque.clear();
                deque.add(end+1);
            }
            end++;
            
            if(deque.peekFirst() <= end-k) deque.removeFirst();
            if(end >= k-1){
                ans[end-k+1] = deque.size() == k ? nums[end] : -1;
            }
        }
        
        
        return ans;
        
    }
}