class Solution {
    public String removeStars(String s) {
        
        char[] ans = s.toCharArray();
        int k = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '*') k--;
            else ans[k++] = s.charAt(i);
        }
        
        return new String(ans).substring(0, k);
        
    }
}