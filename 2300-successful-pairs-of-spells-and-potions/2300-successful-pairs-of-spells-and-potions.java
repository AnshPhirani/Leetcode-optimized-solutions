class Solution {
    
    private int lowerBound(long spell, int[] potions, long success){
        int m = potions.length;
        int l = 0;
        int h = m;
        while(l < h){
            int mid = l + (h-l)/2;
            if(spell*potions[mid] >= success){
                h = mid;
            }
            else{
                l = mid+1;
            }
        }
        
        return l;
        
    }
    
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        Arrays.sort(potions);
        int[] res = new int[n];
        
        for(int i = 0; i < n; i++){
            res[i] = m - lowerBound(spells[i], potions, success);
        }
        
        return res;
        
    }
}