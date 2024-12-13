class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
        for(int i = 0; i < nums.length; i++){
            pq.add(new int[]{nums[i], i});
        }
        
        long score = 0;
        boolean[] visited = new boolean[nums.length];
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int val = cur[0],  idx = cur[1];
            if(visited[idx]) continue;
            visited[idx] = true;
            if(idx-1 >= 0) visited[idx-1] = true;
            if(idx+1 < nums.length) visited[idx+1] = true;
            score += val;
        }
        return score;
    }
}