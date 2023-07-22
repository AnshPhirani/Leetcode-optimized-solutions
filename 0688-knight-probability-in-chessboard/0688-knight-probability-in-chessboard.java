class Solution {
    int[][] dir = {{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    
    public double knightProbability(int n, int k, int row, int column) {
        double[][] curr = new double[n][n];
        double[][] next = new double[n][n];
        
        curr[row][column] = 1d;
        for(int steps = 1; steps <= k; steps++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(curr[i][j] == 0) continue;
                    for(int[] d : dir){
                        int x = i+d[0], y = j+d[1];
                        if(x >= 0 && y >= 0 && x < n && y < n)
                            next[x][y] += curr[i][j]/8;
                    }
                }
            }
            curr = next;
            next = new double[n][n];
        }
        
        double prob = 0;
        for(double[] r : curr){
            for(double val : r) prob += val;
        }
        return prob;
    }
}