class Solution {
    public int minDeletionSize(String[] strs) {
        int deletionCount = 0;

        for(int j = 0; j < strs[0].length(); j++){
            for(int i = 1; i < strs.length; i++){
                if(strs[i-1].charAt(j) > strs[i].charAt(j)){
                    deletionCount++;
                    break;
                }
            }
        }
        return deletionCount;
    }
}