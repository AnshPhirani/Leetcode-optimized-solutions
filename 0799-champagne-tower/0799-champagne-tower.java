class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {

        double[] curRow = new double[1];
        curRow[0] = poured;
        for(int row = 1; row <= query_row; row++){
            double[] nextRow = new double[row+1];
            nextRow[0] = Math.max(0, (curRow[0]-1)/2);
            for(int i = 1; i < row; i++){
                nextRow[i] += Math.max(0, (curRow[i-1]-1)/2) + Math.max(0, (curRow[i]-1)/2);
            }
            nextRow[row] = Math.max(0, (curRow[row-1]-1)/2);
            curRow = nextRow;
        }
        
        return Math.min(1, curRow[query_glass]);
        
    }
}