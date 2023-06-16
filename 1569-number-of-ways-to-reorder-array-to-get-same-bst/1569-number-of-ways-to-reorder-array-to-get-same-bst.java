class Solution {
    
    private static final int MOD = (int)1e9 + 7;
    private long[] factorial;
    
    public long binPower(long a, long b){
        long res = 1;
        while(b > 0){
 
            if(b%2 !=0){
                res = (res%MOD * a%MOD)% MOD;
            }
            a = (a%MOD * a%MOD)%MOD;
            b = b>>1;

        }
        return res%MOD;

    }
    
    private long helper(List<Integer> arr){
        if(arr.size() <= 2) return 1;
        
        List<Integer> smaller = new ArrayList<>();
        List<Integer> larger = new ArrayList<>();
        
        int root = arr.get(0);
        for(int i = 1; i < arr.size(); i++){
            if(arr.get(i) < root) smaller.add(arr.get(i));
            else larger.add(arr.get(i));
        }
        
        int n = smaller.size(), m = larger.size();

        // curPossibilities is (n+m)Choose(n) => (n+m)!/(n!*m!)
        long curPossibilities = ((factorial[n+m]%MOD * binPower(factorial[n], MOD-2))%MOD * binPower(factorial[m], MOD-2))%MOD;
        long leftPossibilities = helper(smaller)%MOD;
        long rightPossibilities = helper(larger)%MOD;
        
        return ((curPossibilities * leftPossibilities)%MOD * rightPossibilities)%MOD;
    }
    
    public int numOfWays(int[] nums) {
        int n = nums.length;
        this.factorial = new long[n];
        factorial[0] = 1;
        for(int i = 1; i < n; i++){
            factorial[i] = (factorial[i-1] * i)%MOD;
        }

        List<Integer> arr = new ArrayList<>();
        for(int num : nums) arr.add(num);
        return (int)((helper(arr)-1)%MOD);
    }
}