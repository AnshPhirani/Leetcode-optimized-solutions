class Solution {

    public double separateSquares(int[][] squares) {
        int maxY = 0;
        for(int[] square : squares){
            int y = square[1] + square[2];
            maxY = Math.max(maxY, y);
        }

        double low = 0;
        double high = maxY;
        double ans = -1;
        while(Math.abs(high - low) > 0.00001){
            double mid = (low+high)/2;
            if(isPossible(mid, squares)){
                high = mid;
            }
            else{
                low = mid;
            }
        }

        return high;
    }

    private boolean isPossible(double y, int[][] squares){
        double totalArea = 0;
        double aboveLineArea = 0;
        for(int[] square : squares){
            totalArea += (double)square[2]*square[2];
            double startY = square[1];
            if(startY < y) aboveLineArea += Math.min(y-startY, square[2])*square[2];
        }

        return aboveLineArea >= totalArea/2;
    }

}