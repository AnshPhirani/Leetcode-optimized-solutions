class Solution {
    public boolean isPowerOfThree(int n) {
        if(n < 0) return false;
        
        double temp = Math.log10(n)/Math.log10(3);
        if(temp%1 == 0){
            return true;
            
        }
        return false;
    }
}