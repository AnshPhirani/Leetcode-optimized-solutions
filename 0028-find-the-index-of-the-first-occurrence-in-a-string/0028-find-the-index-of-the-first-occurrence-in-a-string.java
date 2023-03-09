class Solution {
    
    private int[] constructZArray(char[] str){
        int n = str.length;
        int[] zArray = new int[n];
        int left = 0, right = 0;
        
        for(int k = 1; k < n; k++){
            if(k > right){
                left = right = k;        
                while(right < n && str[right] == str[right-left]){
                    right++;
                }
                right--;
                zArray[k] = right-left+1;
            }
            else{
                int k1 = k-left;
                if(zArray[k1] < right-k+1){
                    zArray[k] = zArray[k1];
                }
                else{
                    left = k;
                    while(right < n && str[right] == str[right-left]){
                        right++;
                    }
                    right--;
                    zArray[k] = right-left+1;
                }
            }
        }
        
        return zArray;
    }
    
    
    public int strStr(String text, String pattern) {
        
        char[] newStr = new char[pattern.length() + 1 + text.length()];
        
        int idx  = 0;
        for(char ch : pattern.toCharArray()) newStr[idx++] = ch;
        newStr[idx++] = '#'; // special character
        for(char ch : text.toCharArray()) newStr[idx++] = ch;
        
        int[] zArray = constructZArray(newStr);
        
        for(int i = 0; i < zArray.length; i++){
            if(zArray[i] == pattern.length()) return i-(pattern.length()+1);
        }
        
        return -1;
    }
}