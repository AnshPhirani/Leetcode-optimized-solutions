class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if(n <= 10) return new ArrayList<>();

        Map<String, Integer> freqMap = new HashMap<>();
        
        for(int i = 0; i <= n-10; i++){
            String cur = s.substring(i, i+10);
            freqMap.put(cur, freqMap.getOrDefault(cur, 0)+1);
        }
        
        List<String> res = new ArrayList<>();
        for(String key : freqMap.keySet()){
            if(freqMap.get(key) > 1){
                res.add(key);
            }
        }
        
        return res;
    }
}