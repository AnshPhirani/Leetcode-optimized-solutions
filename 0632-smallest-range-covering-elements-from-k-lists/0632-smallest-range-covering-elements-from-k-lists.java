class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        
 
        int curMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i++){
            curMax = Math.max(curMax, nums.get(i).get(0));
            pq.add(new int[]{nums.get(i).get(0), i, 0});
        }
        
        
        int[] ans = new int[]{0, Integer.MAX_VALUE};
        while(!pq.isEmpty()){
            int[] minPos = pq.poll();
            int minI = minPos[1], minJ = minPos[2];
            int curMin = minPos[0];
            if(ans[1]-ans[0] > curMax-curMin){
                ans[0] = curMin;
                ans[1] = curMax;
            }

            if(minJ+1 == nums.get(minI).size()) break;   
            
            curMax = Math.max(curMax, nums.get(minI).get(minJ+1));
            pq.add(new int[]{nums.get(minI).get(minJ+1), minI, minJ+1});
            
        }
        
        return ans;
        
    }
}