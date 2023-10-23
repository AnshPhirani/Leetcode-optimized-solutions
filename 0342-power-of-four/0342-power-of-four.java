class Solution {
    
    // decimal   binary    hexadecimal
    // (1431655765)  (0101 0101 0101 0101 0101 0101 0101 0101)   (0x55555555)
    
    
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        return (n&(n-1)) == 0 && (n&1431655765) == n;
    }
}