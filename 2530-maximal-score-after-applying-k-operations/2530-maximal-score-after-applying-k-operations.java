class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for(int num : nums) pq.add(num);;
        
        long ans = 0;
        while(k-- > 0){
            int cur = pq.poll();
            ans += cur;
            cur = (int)Math.ceil(1d*cur/3);
            pq.add(cur);
        }
        return ans;
        
    }
}