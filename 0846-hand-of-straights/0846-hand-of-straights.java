class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize != 0) return false;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int val : hand){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        for(int card : hand){
            int startCard = card;
            if(!map.containsKey(startCard)) continue;
            
            while(map.containsKey(startCard-1)) startCard--;
            
            for(int nextCard = startCard; nextCard < startCard+groupSize; nextCard++){
                if(!map.containsKey(nextCard)) return false;
                map.put(nextCard, map.get(nextCard)-1);
                if(map.get(nextCard) == 0) map.remove(nextCard);
            }
        }
        
        return true;
        
    }
}