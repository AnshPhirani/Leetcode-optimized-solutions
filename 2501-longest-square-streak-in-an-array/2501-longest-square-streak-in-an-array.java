class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Long> set = new HashSet<>();
        for(long num : nums) set.add(num);
        
        int maxStreak = -1;
        for(long num : nums){
            int curStreak = 1;
            while(set.contains(num*num)){
                num = num*num;
                curStreak++;
                if(num > 1e5) break;
            }
            if(curStreak >= 2) maxStreak = Math.max(maxStreak, curStreak);
        }
        
        return maxStreak;
    }
}