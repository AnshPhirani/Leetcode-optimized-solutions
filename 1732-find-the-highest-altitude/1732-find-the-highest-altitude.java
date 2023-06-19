class Solution {
    public int largestAltitude(int[] gain) {
        int maxAlt = 0;
        int curAlt = 0;
        for(int val : gain){
            curAlt += val;
            maxAlt = Math.max(maxAlt, curAlt);
        }
        
        return maxAlt;
    }
}