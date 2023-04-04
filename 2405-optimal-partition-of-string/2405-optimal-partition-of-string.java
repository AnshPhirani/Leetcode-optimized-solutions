class Solution {
    public int partitionString(String s) {
        int curSubstring = 0;
        int count = 1;
        for(char ch : s.toCharArray()){
            int mask = 1<<(ch-'a');
            if((mask&curSubstring) == 0){
                curSubstring |= mask;
            }
            else{
                count++;
                curSubstring = mask;
            }
        }
        
        return count;
    }
}