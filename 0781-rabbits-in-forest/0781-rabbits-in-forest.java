class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int ans : answers){
            freq.put(ans, freq.getOrDefault(ans, 0)+1);
        }
        
        int minRabbits = 0;
        for(int ans : freq.keySet()){
            int count = freq.get(ans);
            int groups = count%(ans+1) == 0 ? count/(ans+1) : count/(ans+1) + 1;
            minRabbits += groups * (ans+1);
        }
        
        return minRabbits;
        
    }
}