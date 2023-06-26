class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] != b[0] ? a[0]-b[0] : a[1]-b[1];
        });
        
        int left = 0;
        for(; left < candidates; left++) 
            pq.add(new int[]{costs[left], left});
        
        int right = n-1;
        for(; right > n-1-candidates && right >= left; right--) 
            pq.add(new int[]{costs[right], right});
    
        
        long cost = 0;
        while(k-- > 0){
            int[] curCandidate = pq.poll();
            cost += curCandidate[0];
            if(left > right) continue;
            
            if(curCandidate[1] < left){
                pq.add(new int[]{costs[left], left});
                left++;
            }
            else{
                pq.add(new int[]{costs[right], right});
                right--;
            }
        }
        
        return cost;
    }
}