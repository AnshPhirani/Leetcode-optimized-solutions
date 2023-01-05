class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        
        int maxLen = 0;
        for(int num : nums){
            if(!set.contains(num)) continue;
            
            int curLen = 1;
            int temp = num-1;
            while(set.contains(temp)){
                curLen++;
                set.remove(temp);
                temp--;
            }
            
            temp = num+1;
            while(set.contains(temp)){
                curLen++;
                set.remove(temp);
                temp++;
            }
            maxLen = Math.max(maxLen, curLen);
        }
        
        return maxLen;
    }
}