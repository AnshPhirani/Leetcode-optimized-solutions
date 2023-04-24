class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for(int stone : stones) pq.add(stone);
        
        while(pq.size() > 1){
            int larger = pq.poll();
            int large = pq.poll();
            if(larger == large) continue;
            else pq.add(larger-large);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}