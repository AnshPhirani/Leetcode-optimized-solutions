class Solution {
    
    
    public int tallestBillboard(int[] rods) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        
        for(int rod : rods){
            Map<Integer, Integer> newDp = new HashMap<>(dp);
            
            for(int diff : dp.keySet()){
                int taller = dp.get(diff);
                int shorter = taller-diff;
                
                // adding cur rod to taller stand
                int newTaller = newDp.getOrDefault(diff+rod, 0);
                newDp.put(diff+rod, Math.max(newTaller, taller+rod));
                
                // adding cur rod to shorted stand
                int newDiff = Math.abs(shorter + rod - taller);
                int newTaller2 = Math.max(shorter + rod, taller);
                newDp.put(newDiff, Math.max(newTaller2, newDp.getOrDefault(newDiff, 0)));
            }
            dp = newDp;
        }
        
        return dp.getOrDefault(0, 0);
    }
}