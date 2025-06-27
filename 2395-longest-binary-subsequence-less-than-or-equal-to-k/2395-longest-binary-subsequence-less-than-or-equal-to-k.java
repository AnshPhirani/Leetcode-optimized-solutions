class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int len = 0;
        int sum = 0;
        int pos = 0;
        int bits = (int) (Math.log(k) / Math.log(2)) + 1;
        for (int end = n - 1; end >= 0; end--) {
            if(s.charAt(end) == '1'){
                if(pos < bits && sum + (1<<pos) <= k){
                    sum += 1<<pos;
                }
                else {
                    pos++;
                    continue;
                }
            }

            pos++;
            len++;
        }
        return len;
    }
}