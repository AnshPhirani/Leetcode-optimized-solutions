class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<String>[] count = new HashSet[26];
        for(int i = 0; i < 26; i++) count[i] = new HashSet();
        
        for(String idea : ideas){
            count[idea.charAt(0) - 'a'].add(idea.substring(1));
        }
        
        long res = 0;
        
        for(int i = 0; i < 26; i++){
            for(int j = i+1; j < 26; j++){
                int c1 = 0, c2 = 0;
                for(String suffix : count[i]){
                    if(!count[j].contains(suffix)) c1++;
                }
                for(String suffix : count[j]){
                    if(!count[i].contains(suffix)) c2++;
                }
                res += c1*c2;   
            }
        }
        
        return res*2;
    }
}