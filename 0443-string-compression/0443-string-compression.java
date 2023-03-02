class Solution {
    public int compress(char[] chars) {
        
        int idx = 0;
        char curChar = chars[0];
        int curFreq = 1;
        for(int i = 1; i < chars.length; i++){
            if(chars[i] == curChar){
                curFreq++;
            }
            else{
                chars[idx++] = curChar;
                if(curFreq  != 1){
                    String temp = String.valueOf(curFreq);
                    for(char ch : temp.toCharArray()) chars[idx++] = ch;
                }
                curChar = chars[i];
                curFreq = 1;
            }
        }
        
        chars[idx++] = curChar;
        if(curFreq  != 1){
            String temp = String.valueOf(curFreq);
            for(char ch : temp.toCharArray()) chars[idx++] = ch;
        }
        
        
        return idx;
    }
}