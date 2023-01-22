class Solution {
    
    private int calculateGCD(int a, int b){
        if(b==0) return a;
        else return calculateGCD(b, a%b);
    }
    
    public boolean isReachable(int targetX, int targetY) {
        int gcd = calculateGCD(targetX, targetY);
        return (gcd & (gcd-1)) == 0;
    }
}