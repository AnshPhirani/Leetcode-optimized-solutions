class Solution {
    public String makeFancyString(String s) {
        int curConsecutiveCount = 1;
        StringBuilder ans = new StringBuilder("" + s.charAt(0));
        
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                curConsecutiveCount++;
            }
            else{
                curConsecutiveCount = 1;
            }
            if(curConsecutiveCount <= 2) ans.append(s.charAt(i));
        }
        
        return ans.toString();
    }
}