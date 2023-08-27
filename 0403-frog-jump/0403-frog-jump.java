class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Map<Integer, Boolean>> dp = new HashMap<>();
        for(int stone : stones) dp.put(stone, new HashMap<>());
        
        dp.get(0).put(0, true);
        
        for(int stone : stones){
            Map<Integer, Boolean> cur = dp.get(stone);
            for(int prevJump : cur.keySet()){
                if(!cur.get(prevJump)) continue;
                
                // start jumping from current postion
                for(int i = -1; i <= 1; i++){
                    int nextJump = prevJump+i;
                    if(nextJump <= 0 || nextJump > 2000) continue;
                    if(dp.containsKey(stone+nextJump)){
                        dp.get(stone+nextJump).put(nextJump, true);
                    }
                }
            }
        }
        
        return !dp.get(stones[stones.length-1]).isEmpty(); 
    }
}