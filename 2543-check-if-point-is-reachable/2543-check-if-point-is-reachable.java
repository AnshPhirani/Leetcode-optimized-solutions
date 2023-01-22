class Solution {
    
    private int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b, a%b);
    }
    
    public boolean isReachable(int targetX, int targetY) {
        int gcd = gcd(targetX, targetY);
        if((gcd & (gcd-1)) == 0) return true;
        else return false;
    }
}