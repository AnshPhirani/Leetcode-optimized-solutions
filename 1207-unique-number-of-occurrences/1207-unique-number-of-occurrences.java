class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int val : arr) freq.put(val, freq.getOrDefault(val, 0) + 1);
        Set<Integer> values = new HashSet<>(freq.values());
        
        return values.size() == freq.values().size();
    }
}