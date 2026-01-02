class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for(int num : nums){
            if(visited.contains(num)) return num;
            visited.add(num);
        }
        return -1;
    }
}