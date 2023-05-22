class Pair{
    int val, freq;
    public Pair(int v, int f){
        val = v;
        freq = f;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.freq-b.freq);
        for(int key : map.keySet()){
            pq.add(new Pair(key, map.get(key)));
            if(pq.size() > k) pq.poll();
        }
        
        int[] res = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()){
            res[idx++] = pq.poll().val;
        }
        
        return res;
    }
}