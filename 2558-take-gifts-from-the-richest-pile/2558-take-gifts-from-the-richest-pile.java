class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for(int gift : gifts){
            pq.add(gift);
        }
        
        while(k-- > 0){
            int leftGifts = (int)Math.floor(Math.sqrt(pq.poll()));
            pq.add(leftGifts);
        }
        
        long ans = 0;
        while(!pq.isEmpty()) ans += pq.poll();
        return ans;
    }
}