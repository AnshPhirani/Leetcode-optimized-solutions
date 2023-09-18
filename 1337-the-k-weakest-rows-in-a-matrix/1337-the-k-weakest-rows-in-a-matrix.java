class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0]-a[0] : b[1]-a[1]);
        int[] ans = new int[k];
        
        for(int i = 0; i < mat.length; i++){
            int soldiersCount = 0;
            for(int val : mat[i]){
                if(val == 0) break;
                soldiersCount++;
            }
            pq.add(new int[]{i, soldiersCount});
            if(pq.size() > k) pq.poll();    
        }   
        
        while(k-- > 0){
            ans[k] = pq.poll()[0];
        }
        return ans;
        
    }
}