class Solution {
    public int possibleStringCount(String word) {
        int ans = 1;
        int curCharCount = 0;
        char curChar = word.charAt(0);
        for(char ch : word.toCharArray()){
            if(ch == curChar){
                curCharCount++;
            }
            else{
                ans += curCharCount-1;
                curChar = ch;
                curCharCount = 1;
            }
        }
        ans += curCharCount-1;
        return ans;
    }
}