class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        int count = 0;
        int l = 0, r = 1;
        while(r < intervals.length){
            // overlapping intervals
            if(intervals[r][0] < intervals[l][1]){
                if(intervals[l][1] > intervals[r][1]){
                    l = r;
                }
                r++;
                count++;
            }
            else{ // not overlapping intervals
                l = r;
                r++;
            }
        }
        
        return count;
    }
}