class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int seconds = 0;
        for(int idx = 1; idx < points.length; idx++){
            int x1 = points[idx-1][0], y1 = points[idx-1][1];
            int x2 = points[idx][0], y2 = points[idx][1];
            seconds += Math.max(Math.abs(x2-x1), Math.abs(y2-y1));
        }
        return seconds;
    }
}