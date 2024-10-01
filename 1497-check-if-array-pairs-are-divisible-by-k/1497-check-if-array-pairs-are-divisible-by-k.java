class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int val : arr){
            val = val%k;
            if(val < 0) val += k;
            int comp = k - val;
            if(freq.getOrDefault(comp, 0) > 0){
                freq.put(comp, freq.get(comp)-1);
                if(freq.get(comp) == 0) freq.remove(comp);
            }
            else{
                freq.put(val, freq.getOrDefault(val, 0)+1);
            }
        }
        if(freq.containsKey(0) && freq.get(0)%2 == 0) freq.remove(0);
            
        return freq.isEmpty();
    }
}