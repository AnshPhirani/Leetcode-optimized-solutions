class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxCount = 0;
        int start = 0, end = 0;
        
        while(end < fruits.length){
            int curFruitType = fruits[end];
            freqMap.put(curFruitType, freqMap.getOrDefault(curFruitType, 0) + 1);
            while(freqMap.size() > 2){
                freqMap.put(fruits[start], freqMap.get(fruits[start])-1);
                if(freqMap.get(fruits[start]) == 0) freqMap.remove(fruits[start]);
                start++;
            }
            
            maxCount = Math.max(maxCount, end-start+1);
            end++;
        }
        
        return maxCount;
    }
}