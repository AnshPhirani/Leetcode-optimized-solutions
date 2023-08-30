class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long count = 0;
        long next = nums[n-1];
        for(int i = n-2; i>= 0; i--){
            long cur = nums[i];
            long noOfTime=cur/next; 
            if(cur%next!=0){
			    noOfTime++;
                next=nums[i]/noOfTime;
            }   
            count +=noOfTime-1;
        }
        
        return count;
    }
}