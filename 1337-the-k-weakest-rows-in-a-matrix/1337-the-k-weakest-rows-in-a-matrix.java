class Solution {
    
    private int onesCount(int[] arr){
        int l = 0;
        int h = arr.length-1;
        int res = 0;
        while(l <= h){
            int mid = l+(h-l)/2;
            if(arr[mid] == 1){
                l = mid+1;;
                res = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return res;
    }
    
    
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0]-a[0] : b[1]-a[1]);
        int[] ans = new int[k];
        
        for(int i = 0; i < mat.length; i++){
            int soldiersCount = onesCount(mat[i]);
            pq.add(new int[]{i, soldiersCount});
            if(pq.size() > k) pq.poll();    
        }   
        
        while(k-- > 0){
            ans[k] = pq.poll()[0];
        }
        return ans;
        
    }
}