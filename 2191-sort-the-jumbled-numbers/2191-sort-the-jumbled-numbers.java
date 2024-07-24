class Solution {
    
    private int getMappedValue(int value, int[] mapping){
        String num = String.valueOf(value);
        int mappedVal = 0;
        for(char ch : num.toCharArray()){
            mappedVal *= 10;
            mappedVal += mapping[ch-'0'];
        }
        return mappedVal;
    }
    
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] mapped = new int[n][2];
        for(int i = 0; i < n; i++){
            mapped[i][0] = nums[i];
            mapped[i][1] = getMappedValue(nums[i], mapping);
        }
        
        Arrays.sort(mapped, (a, b) -> a[1]-b[1]);

        for(int i = 0; i < n; i++) nums[i] = mapped[i][0];
        return nums;
    }
}