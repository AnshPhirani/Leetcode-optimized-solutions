class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch : s.toCharArray()) freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        for(Map.Entry<Character,Integer> entry : freqMap.entrySet()) pq.add(entry);
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> entry = pq.poll();
            String key = "" + entry.getKey();
            sb.append(key.repeat(entry.getValue()));
        }
        
        return sb.toString();
    }
}