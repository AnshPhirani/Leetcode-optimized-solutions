class Solution {
    public int numberOfMatches(int n) {
        if(n == 1) return 0;
        return n%2 == 0 ? n/2 + numberOfMatches(n/2) : (n-1)/2 + numberOfMatches((n-1)/2 + 1);
    }
}