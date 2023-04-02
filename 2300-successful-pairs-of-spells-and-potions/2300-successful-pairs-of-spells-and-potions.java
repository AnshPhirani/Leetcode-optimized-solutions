class Solution {

    
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        
        int[][] sortedSpells = new int[n][2];
        for(int i = 0; i < n; i++){
            sortedSpells[i][0] = spells[i];
            sortedSpells[i][1] = i;
        }
        
        Arrays.sort(sortedSpells, (a, b) -> Integer.compare(a[0],b[0]));
        Arrays.sort(potions);
        
        
        int[] res = new int[n];
        
        int k = m-1;
        for(int[] sortedSpell : sortedSpells){
            int spell = sortedSpell[0];
            int idx = sortedSpell[1];
            while(k >= 0 && (long)spell*potions[k] >= success) k--;
            res[idx] = m-(k+1);
        }
        
        return res;
        
    }
}