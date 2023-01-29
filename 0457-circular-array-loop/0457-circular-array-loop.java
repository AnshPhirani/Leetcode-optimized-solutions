class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        
        for(int start = 0; start < n; start++){
            if(Math.abs(nums[start])%n == 0) continue;
            Arrays.fill(visited, false);
            boolean hasPositive = nums[start] > 0;
            int end = (start + nums[start])%n;
            if(end < 0) end += n; 

            while(end != start){
                if(hasPositive != (nums[end] > 0)) break;
                if(visited[end]) break;
                visited[end] = true;
                end = (end + nums[end])%n;
                if(end < 0) end += n; 
            }
            
            if(end == start) return true;
        }
        return false;
    }
}