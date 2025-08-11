class Solution {

    private static final int MOD = (int)1e9+7;

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        int pos = 0;
        while(n > 0){
            if(n%2 == 1) powers.add((1<<pos));
            n >>= 1;
            pos++;
        }

        // System.out.println(powers);

        int[] ans = new int[queries.length];

        int k = 0;
        for(int[] query : queries){
            int s = query[0], e = query[1];
            long val = 1;
            for(int i = s; i <= e; i++){
                val = val*powers.get(i);
                val %= MOD;
            }
            ans[k++] = (int)val;
        }

        return ans; 
    }
}


// 1111

// 8 4 2 1 

// 10
// 2