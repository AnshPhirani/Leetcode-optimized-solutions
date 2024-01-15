class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lostCount = new HashMap<>();
        Set<Integer> winners = new HashSet<>();
        for(int[] match : matches){
            int winner = match[0];
            int loser = match[1];
            lostCount.put(loser, lostCount.getOrDefault(loser, 0) + 1);
            winners.add(winner);
        }
        
        List<Integer> notLost = new ArrayList<>();
        List<Integer> lostOne = new ArrayList<>();
        
        for(int winner : winners)
            if(!lostCount.containsKey(winner)) notLost.add(winner);
        
        for(int loser : lostCount.keySet())
            if(lostCount.get(loser) == 1) lostOne.add(loser);
        
        Collections.sort(notLost);
        Collections.sort(lostOne);
        return List.of(notLost, lostOne);
    }
}