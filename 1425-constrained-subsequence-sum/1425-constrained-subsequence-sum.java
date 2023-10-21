class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        
        pq.add(new int[]{nums[0], 0});
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            while(i - pq.peek()[1] > k) pq.poll();
            
            int current = Math.max(0, pq.peek()[0]) + nums[i];
            ans = Math.max(ans, current);
            pq.add(new int[]{current, i});
        }
        
        return ans;
    }
}