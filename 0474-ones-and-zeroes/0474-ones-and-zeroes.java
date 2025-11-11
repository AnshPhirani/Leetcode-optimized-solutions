class Solution {
    Integer[][][] memo;

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] zerosOnesCount = new int[len][2];
        for(int idx = 0; idx < len; idx++){
            for(char ch : strs[idx].toCharArray()){
                if(ch == '0') zerosOnesCount[idx][0]++;
                else zerosOnesCount[idx][1]++;
            }
        }
        this.memo = new Integer[len][n+1][m+1];
        return helper(0, 0, 0, n, m, zerosOnesCount);
    }

    private int helper(int idx, int curN, int curM, int n, int m, int[][] zerosOnesCount){
        if(idx == zerosOnesCount.length) return 0;

        if(memo[idx][curN][curM] != null) return memo[idx][curN][curM];


        // skip current string
        int skip = helper(idx+1, curN, curM, n, m, zerosOnesCount);

        // include current string
        int newN = curN+zerosOnesCount[idx][1];
        int newM = curM+zerosOnesCount[idx][0];
        int include = 0;
        if(newM <= m && newN <= n)
            include = 1 + helper(idx+1, newN, newM, n, m, zerosOnesCount);

        return memo[idx][curN][curM] = Math.max(skip, include);
    }

}