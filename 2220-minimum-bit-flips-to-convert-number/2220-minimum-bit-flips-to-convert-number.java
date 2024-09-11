class Solution {
    public int minBitFlips(int start, int goal) {
        int pos = 0;
        int flips = 0;
        while(start > 0 || goal > 0){
            if((start%2) != (goal%2)){
                flips++;
            }
            start >>= 1;
            goal >>= 1;
        }
        return flips;
    }
}