class Solution {
    public long numberOfWays(String s) {
        int n = s.length();

        long[] count01 = new long[n];
        long[] count10 = new long[n];
        long[] prefix0 = new long[n];
        long[] prefix1 = new long[n];
        long total0 = 0, total1 = 0;

        for (int idx = 0; idx < n; idx++) {
            char ch = s.charAt(idx);

            if (idx > 0) {
                if (ch == '0')
                    count10[idx] = prefix1[idx - 1];
                else
                    count01[idx] = prefix0[idx - 1];
            }

            if(idx > 0) {
                prefix1[idx] = prefix1[idx-1];
                prefix0[idx] = prefix0[idx-1];
            }

            if (ch == '0') {
                prefix0[idx]++;
                total0++;
            } else {
                prefix1[idx]++;
                total1++;
            }
        }

        long ways = 0;
        for (int idx = 1; idx < n - 1; idx++) {
            ways += count01[idx] * (total0 - prefix0[idx]);
            ways += count10[idx] * (total1 - prefix1[idx]);
        }
        return ways;
    }
}