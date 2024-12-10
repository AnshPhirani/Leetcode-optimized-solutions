class Solution {
    
    private boolean hasFreqThrice(String substring, String s){
        int count = 0;
        int len = substring.length();
        for(int i = 0; i <= s.length()-len; i++){
            if(s.substring(i, i+len).equals(substring)) count++;
        }
        return count >= 3;
    }
    
    public int maximumLength(String s) {
        int n = s.length();
        int ans = -1;
        for(int start = 0; start < n; start++){
            String curSubstring = "";
            for(int end = start; end < n; end++){
                if(end > start && s.charAt(end) != s.charAt(end-1)) break;
                curSubstring += s.charAt(end);
                if(hasFreqThrice(curSubstring, s)) ans = Math.max(ans, end-start+1);
            }
        }
        
        return ans;
    }
}
