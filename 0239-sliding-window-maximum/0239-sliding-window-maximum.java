class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> que = new ArrayDeque<>();
        
        int[] res = new int[n-k+1];
        for(int idx = 0; idx < n; idx++){
            while(!que.isEmpty() && que.peekFirst() <= idx-k) que.pollFirst();
            while(!que.isEmpty() && nums[que.peekLast()] < nums[idx]) que.pollLast();
            que.addLast(idx);
            
            if(idx >= k-1){
                 res[idx-k+1] = nums[que.peekFirst()];
            }
        }
        return res;
    }
}