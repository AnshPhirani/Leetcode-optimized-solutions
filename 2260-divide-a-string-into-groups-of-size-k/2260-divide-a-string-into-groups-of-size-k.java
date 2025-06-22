class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len = s.length()/k;
        if(s.length()%k != 0) len++;  
        String[] ans = new String[len];
        Arrays.fill(ans, "");
        for(int idx = 0; idx < s.length(); idx++){
            ans[idx/k] += s.charAt(idx);
        }
        while(ans[len-1].length() < k) ans[len-1] += fill;
        return ans;

    }
}