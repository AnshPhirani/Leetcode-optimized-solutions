class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int task : tasks){
            freqMap.put(task, freqMap.getOrDefault(task, 0)+1);
        }
        
        int rounds = 0;
        for(int task : freqMap.keySet()){
            int count = freqMap.get(task);
            if(count == 1) return -1;
            else if(count%3 == 0) rounds += count/3;
            else if(count%3 == 1){
                rounds += (count-4)/3 + 2;
            }
            else{
                rounds += count/3 + 1;
            }
        }
        
        return rounds;
    }
}