class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1l);
        Set<Long> visited = new HashSet<>();
        visited.add(1l);
        while(n > 1){
            long cur = pq.poll();
            // System.out.println(cur);
            if(!visited.contains(cur*2)){
                pq.add(cur*2);
                visited.add(cur*2);
            }
            if(!visited.contains(cur*3)){
                pq.add(cur*3);
                visited.add(cur*3);
            }
            if(!visited.contains(cur*5)){
                pq.add(cur*5);
                visited.add(cur*5);
            }
            n--;
        }
        
        long ans = pq.peek();
        return (int)ans;
    }
}