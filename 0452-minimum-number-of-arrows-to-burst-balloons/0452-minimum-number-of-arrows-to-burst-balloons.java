class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if(a[0] > b[0]) return 1;
            else if(a[0] < b[0]) return -1;
            else if(a[1] > b[1]) return 1;
            else  return -1;
        }); 
        
        int arrows = 0;
        int start = points[0][0], end = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] <= end){
                start = Math.max(start, points[i][0]);
                end = Math.min(end, points[i][1]);
            }
            else{
                arrows++;
                start = points[i][0];
                end = points[i][1];
            }
        }
        
        return arrows+1;
        
    }
}