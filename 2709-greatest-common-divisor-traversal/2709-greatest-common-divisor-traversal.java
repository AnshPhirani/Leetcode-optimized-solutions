class Solution {
    
    Map<Integer, List<Integer>> index2Prime, prime2Index;
    Map<Integer, Boolean> visitedPrime;
    boolean[] visitedIndex;
    
    
    private void dfs(int index){
        if(visitedIndex[index]) return;
        visitedIndex[index] = true;
        
        for(int prime : index2Prime.get(index)){
            if(visitedPrime.getOrDefault(prime, false)) continue;
            visitedPrime.put(prime, true);
            for(int nextIndex : prime2Index.get(prime)){
                if(visitedIndex[nextIndex]) continue;
                dfs(nextIndex);
            }
        }
        
    }
    
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;
        
        this.index2Prime = new HashMap<>();
        this.prime2Index = new HashMap<>();
        this.visitedPrime = new HashMap<>();
        this.visitedIndex = new boolean[n];
        
        index2Prime.putIfAbsent(0, new ArrayList<>());
        
        for(int i = 0; i < n; i++){
            int num = nums[i];
            for(int j = 2; j*j <= nums[i]; j++){
                if(num%j == 0){      
                    index2Prime.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    prime2Index.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                    while(num%j == 0) num /= j;
                }
            }
            if(num > 1){
                index2Prime.computeIfAbsent(i, k -> new ArrayList<>()).add(num);
                prime2Index.computeIfAbsent(num, k -> new ArrayList<>()).add(i);
            }
        }
              

        dfs(0);
        
        System.out.println(Arrays.toString(visitedIndex));
        for(boolean b : visitedIndex){
            if(!b) return false;
        }
        return true;
        
    }
}