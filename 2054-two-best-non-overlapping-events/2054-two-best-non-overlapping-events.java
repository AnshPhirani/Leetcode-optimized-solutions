class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0]-b[0]);

        int[] suffixMax = new int[n];
        suffixMax[n-1] = events[n-1][2];
        for(int idx = n-2; idx >= 0; idx--){
            suffixMax[idx] = Math.max(suffixMax[idx+1], events[idx][2]);
        }


        int maxAns = 0;
        for(int idx = 0; idx < n; idx++){
            int[] curEvent = events[idx];

            // choose curEvent
            int curAns = curEvent[2];

            // Get the max Value for other non overlapping intervals
            int nextNonOverlapIntervalIdx = findNextInterval(idx+1, n-1, curEvent[1]+1, events);
            if(nextNonOverlapIntervalIdx != -1) curAns += suffixMax[nextNonOverlapIntervalIdx];

            maxAns = Math.max(maxAns, curAns);
        }

        return maxAns;
    }

    private int findNextInterval(int left, int right, int minStart, int[][] events){
        int nextIdx = -1;
        while(left <= right){
            int mid = (left+right)/2;
            if(events[mid][0] < minStart){
                 left = mid+1;
            }
            else if(events[mid][0] >= minStart){
                nextIdx = mid;
                right = mid-1;
            }
        }
        return nextIdx;
    }
}