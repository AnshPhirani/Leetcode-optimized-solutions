class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Long> set = new HashSet<>();
        for(long num : nums) set.add(num);
        
        Arrays.sort(nums);
        int maxStreak = -1;
        for(long num : nums){
            int curStreak = 1;
            while(set.contains(num*num)){
                set.remove(num*num);
                num = num*num;
                curStreak++;
            }
            if(curStreak >= 2) maxStreak = Math.max(maxStreak, curStreak);
        }
        
        return maxStreak;
    }
}