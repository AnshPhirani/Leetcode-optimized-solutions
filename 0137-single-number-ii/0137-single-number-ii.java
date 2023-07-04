class Solution {
    public int singleNumber(int[] nums) {
        int[] bitsCount = new int[32];
 
        for(int i = 0; i < 32; i++){
            for(int num : nums){
                if((num & (1 << i)) != 0){
                    bitsCount[i]++;
                }
            }
        }
        
        for(int i = 0; i < 32; i++){
            bitsCount[i] %= 3;
        }
        
        int ans = 0;
        for(int i = 0; i < 32; i++){
            ans += bitsCount[i] * (1 << i);
        }
        
        return ans;
    }
}