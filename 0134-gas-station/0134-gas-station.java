class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = cost.length;
        
        int startIdx = 0;
        int curGas = gas[0];
        for(int i = 1; i < 2*n; i++){
            curGas -= cost[(i-1)%n];
            if(curGas < 0){
                startIdx = i;
                curGas = gas[i%n];
            }
            else{
                curGas += gas[i%n];
            }
            if(i-startIdx == n) return startIdx;
        }
        
        return -1;
        
    }
}