class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int i = 0;
        for(i = 1; i < heights.length; i++){
            int curHeight = heights[i];
            int prevHeight = heights[i-1];
            if(curHeight > prevHeight){
                pq.add(curHeight-prevHeight);
                if(pq.size() > ladders){
                    if(bricks >= pq.peek()){
                        bricks -= pq.poll();
                    }
                    else{
                        return i-1;
                    }
                }
            }
        }
        return i-1;
    }
}