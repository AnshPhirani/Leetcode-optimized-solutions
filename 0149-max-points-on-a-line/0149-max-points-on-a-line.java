class Solution {
    
    private boolean liesOnLine(int[] point1, int[] point2, int[] point3){
        double x1 = point1[0],  y1 = point1[1];
        double x2 = point2[0],  y2 = point2[1];
        double x3 = point3[0],  y3 = point3[1];
        
        double slope1 = (y2-y1) / (x2-x1);
        double slope2 = (y3-y1) / (x3-x1);
        return slope1 == slope2;
        
    }
    
    public int maxPoints(int[][] points) {
        int n = points.length;
        int maxPoints = 1;
        
        for(int i= 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int curPoints = 2;
                for(int k = 0; k < n; k++){
                    if(k != i && k != j && liesOnLine(points[i], points[j], points[k])){
                        curPoints++;
                    }
                }
                maxPoints = Math.max(maxPoints, curPoints);
            }
        }
        
        return maxPoints;
    }
}