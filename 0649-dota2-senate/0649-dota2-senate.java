class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rad = new LinkedList<>(), dire = new LinkedList<>();
        
        int idx = 0;
        for(char ch : senate.toCharArray()){
            if(ch == 'R') rad.add(idx++);
            else dire.add(idx++);
        }
        
        while(!rad.isEmpty() && !dire.isEmpty()){
            if(rad.peek() < dire.peek()){
                rad.add(idx++);
            }
            else{
                dire.add(idx++);
            }
            dire.poll();
            rad.poll();
        }
        
        return dire.isEmpty() ? "Radiant" : "Dire";
        
    }
}