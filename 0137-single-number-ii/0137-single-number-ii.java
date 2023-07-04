class Solution {
    public int singleNumber(int[] nums) {
        int[] bitsCount = new int[32];
        int negCount = 0;
        for(long num : nums){
            if(num < 0){
                negCount++;
                num = -num;
            }
            int pos = 0;
            while(num > 0){
                if((num&1) != 0) bitsCount[pos]++;
                num >>= 1;
                pos++;
            }
        }

        
        int ans = 0;
        for(int i = 0; i < 32; i++){
            bitsCount[i] %= 3;
            if(bitsCount[i] == 1) ans += (1<<i);
        }
        return negCount%3 == 0 ? ans : -ans;
    }
}