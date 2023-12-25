class Solution {

    Integer[] memo;

    private int helper(int idx, int n, String s){
        if(idx == n) return 1;

        if(memo[idx] != null) return memo[idx];

        if(s.charAt(idx) == '0') return 0;

        int curAns = helper(idx+1, n, s);
        if(idx+1 >= n) return memo[idx] = curAns;

        int num = Integer.parseInt("" + s.charAt(idx) + s.charAt(idx+1));
        if(num >= 1 && num <= 26){
            curAns += helper(idx+2, n, s);
        }
        return memo[idx] = curAns;
    }

    public int numDecodings(String s) {
        memo = new Integer[s.length()];
        return helper(0, s.length(), s);
    }
}