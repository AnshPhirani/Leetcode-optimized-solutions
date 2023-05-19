class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1]-b[1]);

        int count = 0;
        int prevEnd = intervals[0][1];
        for(int idx = 1; idx < intervals.length; idx++){
            int start = intervals[idx][0], end = intervals[idx][1];
            if(start >= prevEnd){ // non overlapping
                prevEnd = end;
            }
            else{
                count++;
            }
        }
        return count;
    }
}