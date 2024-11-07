class Solution {
    public int largestCombination(int[] candidates) {
        int[] count = new int[32];
        for(int candidate : candidates){
            int idx = 0;
            while(candidate > 0){
                if((candidate&1) != 0){
                    count[idx]++;
                }
                candidate >>= 1;
                idx++;
            }
        }
        
        return Arrays.stream(count).max().getAsInt();
        
    }
}

// 0010000
// 0010001
// 1000111
// 0111110
// 0001100
// 0011000
// 0001110