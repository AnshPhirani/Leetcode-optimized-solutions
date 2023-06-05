class Solution {
    private double calcSlope(int[] pt1, int[] pt2){
        double x1 = pt1[0], y1 = pt1[1];
        double x2 = pt2[0], y2 = pt2[1];
        
        if(x2-x1 == 0) return Integer.MAX_VALUE;
        return (y2-y1)/(x2-x1);
        
    } 
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if(n == 2) return true;
        
        for(int i = 1; i < n-1; i++){
           if(calcSlope(coordinates[i-1], coordinates[i]) !=  calcSlope(coordinates[i], coordinates[i+1])){
               return false;
           } 
        }
        return true;
    }
}