class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int firstEle = -1, firstCount = 0;
        int secondEle = -1, secondCount = 0;
        
        for(int num : nums){
            if(num == firstEle) firstCount++;
            else if(num == secondEle) secondCount++;
            else if(firstCount == 0){
                firstEle = num;
                firstCount = 1;
            }
            else if(secondCount == 0){
                secondEle = num;
                secondCount = 1;
            }
            else{
                firstCount--;
                secondCount--;
            }
        }
        
        firstCount = 0;
        secondCount = 0;
        for(int num : nums){
            if(num == firstEle) firstCount++;
            else if(num == secondEle) secondCount++;
        }
        
        List<Integer> ans = new ArrayList<>();
        if(firstCount > nums.length/3) ans.add(firstEle);
        if(secondCount > nums.length/3) ans.add(secondEle);
        return ans;
        
    }
}