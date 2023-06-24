class Solution {
    
    Map<Integer, Integer> helper(int s, int e, int[] rods){   
        Set<Pair<Integer, Integer>> states = new HashSet<>();
        states.add(new Pair(0, 0));
        
        for(int i = s; i <= e; i++){
            int curRod = rods[i];
            Set<Pair<Integer, Integer>> newStates = new HashSet<>();
            for(Pair<Integer, Integer> cur : states){
                newStates.add(new Pair(cur.getKey()+curRod, cur.getValue()));
                newStates.add(new Pair(cur.getKey(), cur.getValue()+curRod));
            }
            states.addAll(newStates);
        }
        
        Map<Integer, Integer> dp = new HashMap<>();
        for(Pair<Integer, Integer> cur : states){
            int left = cur.getKey();
            int right = cur.getValue();
            dp.put(left-right, Math.max(dp.getOrDefault(left-right, 0), left));
        }
        
        return dp;
    }
    
    public int tallestBillboard(int[] rods) {
        Map<Integer, Integer> firstHalf = helper(0, rods.length/2, rods);
        Map<Integer, Integer> secondHalf = helper(rods.length/2+1, rods.length-1, rods);
        
        int res = 0;
        for(int diff : firstHalf.keySet()){
            if(secondHalf.containsKey(-diff)){
                res = Math.max(res, firstHalf.get(diff) + secondHalf.get(-diff));
            }
        }
        return res;
    }
}