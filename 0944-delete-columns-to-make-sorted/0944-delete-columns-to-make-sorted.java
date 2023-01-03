class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int len = strs[0].length();
        int count = 0;
        for(int j = 0; j < len; j++){
            char prev = strs[0].charAt(j);
            for(int i = 1; i < n; i++){
                char curr = strs[i].charAt(j);
                if(curr < prev){
                    count++;
                    break;
                }
                prev = curr;
            }
        }
        
        return count;
    }
}