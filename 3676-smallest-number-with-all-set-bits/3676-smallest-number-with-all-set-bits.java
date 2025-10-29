class Solution {
    public int smallestNumber(int n) {
        int val = 1;
        while(val < n){
            val = ((val+1)*2)-1; 
        }
        return val;
    }
}