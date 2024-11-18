class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>(
        (a, b) -> Long.compare(a.getKey(), b.getKey())
        );
        
        long curSum = 0;
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            curSum += nums[i];
            if(curSum >= k) minLen = Math.min(minLen, i+1);
            
            while(!pq.isEmpty() && curSum-pq.peek().getKey() >= k){
                minLen = Math.min(minLen, i-pq.peek().getValue());
                pq.poll();
            }
            pq.add(new Pair(curSum, i));
        }
        
        return minLen == Integer.MAX_VALUE ? -1 : minLen; 
    }
}