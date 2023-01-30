class Solution {
    
    private int getNext(int[] nums, int i){
        int n = nums.length;
        int next = (i+nums[i])%n;
        if(next < 0) next += n;
        return next;
    }
    
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            nums[i] %= n;
        }
       
        for(int i = 0; i < n; i++){
            if(nums[i] == 0) continue; // self loop or already visited
            
            int slow = getNext(nums, i);
            int fast = getNext(nums, getNext(nums, i));
            boolean hasPositives = nums[i] > 0;
 
            
            while(hasPositives == (nums[fast] > 0) && hasPositives == (nums[slow] > 0) && nums[slow] != 0 && nums[fast] != 0){
       
                if(slow == fast) return true;
                slow = getNext(nums, slow);
                fast = getNext(nums, fast);
                if(hasPositives != nums[fast] > 0) break;
                fast = getNext(nums, fast);
          
            }
            
            int cur = i;
            while(nums[cur] != 0 && hasPositives == nums[cur] > 0){
                int next = getNext(nums, cur);
                nums[cur] = 0;
                cur = next;
            }
            
        }
        return false;   
    }
}