class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();
        for(int ban : banned) bannedSet.add(ban);
        
        int curSum = 0;
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(!bannedSet.contains(i)){
                if(curSum + i <= maxSum){
                    curSum += i;
                    count++;
                }
                else return count;
            }
        }
     
        return count;
    }
}