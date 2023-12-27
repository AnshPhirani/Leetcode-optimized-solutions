class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minTime = 0;
        char prevColor = colors.charAt(0);
        int curTimeSum = 0, curMaxTime = Integer.MIN_VALUE;
        for(int idx = 0; idx < neededTime.length; idx++){
            char curColor = colors.charAt(idx);
            if(curColor == prevColor){
                curTimeSum += neededTime[idx];
                curMaxTime = Math.max(curMaxTime, neededTime[idx]);
            } 
            else{
                minTime += curTimeSum - curMaxTime;
                prevColor = curColor;
                curTimeSum = neededTime[idx];
                curMaxTime = neededTime[idx];
            }
        }
        
        minTime += curTimeSum - curMaxTime;
        return minTime;
    }
}