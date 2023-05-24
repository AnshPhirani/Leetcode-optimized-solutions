class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
        }
        Arrays.sort(arr, (a, b) -> a[1]-b[1]);
        

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long maxScore = 0, curSum = 0;
        int idx = n-1;
        
        while(idx >= 0){
            if(pq.size() == k) curSum -= pq.poll();
            pq.add(arr[idx][0]);
            curSum += arr[idx][0];
            if(pq.size() == k){
                long curMin = arr[idx][1];
                maxScore = Math.max(maxScore, curSum*curMin);
            }
            idx--;
        }
        
        return maxScore;
        
    }
}