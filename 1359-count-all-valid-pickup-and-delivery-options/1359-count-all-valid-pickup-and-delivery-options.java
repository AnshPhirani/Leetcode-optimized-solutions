class Solution {
    public int countOrders(int n) {
        int MOD = (int)1e9 + 7;
        
        long res = 1;
        for(int order = 2; order <= n; order++){
            long temp = (order-1)*2 + 1;
            res *= temp*(temp+1)/2;
            res %= MOD;
        }
        return (int)res;
    }
}