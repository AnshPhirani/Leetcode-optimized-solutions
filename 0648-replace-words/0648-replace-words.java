class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        Set<String> set = new HashSet<>();
        for(String root : dictionary) set.add(root);
        
        StringBuilder res = new StringBuilder();
        String[] words = sentence.split(" ");
        
        outer:
        for(String word : words){
            String temp = "";
            for(char ch : word.toCharArray()){
                temp += ch;
                if(set.contains(temp)){
                    res.append(temp + " ");
                    continue outer;
                }
            }
            res.append(word + " ");
        }
        
        return res.substring(0, res.length()-1).toString();
        
        
    }
}