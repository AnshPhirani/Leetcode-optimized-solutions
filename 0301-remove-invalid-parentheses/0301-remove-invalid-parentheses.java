class Solution {
    
    private boolean isValid(String str){
        Stack<Character> st = new Stack<>();
        for(char ch : str.toCharArray()){
            if(ch >= 'a' && ch <= 'z') continue;
            
            if(ch == '(') st.push(ch);
            else if(st.isEmpty() || st.peek() == ')') return false;
            else st.pop();
        }
        
        return st.isEmpty();        
    }
    
    public List<String> removeInvalidParentheses(String s) {
        
        Queue<String> que = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        que.add(s);
        visited.add(s);
        
        List<String> res = new ArrayList<>();

        while(!que.isEmpty()){
            int size = que.size();
            boolean foundValid = false;
            while(size-- > 0){    
                String cur = que.poll();
                if(isValid(cur)){
                    foundValid = true;
                    res.add(cur);
                }
                
                for(int i = 0; i < cur.length() && !foundValid; i++){
                    if(cur.charAt(i) >= 'a' && cur.charAt(i) <= 'z') continue; 
                    String temp = cur.substring(0, i) + cur.substring(i+1);
                    if(!visited.contains(temp)){
                        visited.add(temp);
                        que.add(temp);
                    }
                }
            }
            if(foundValid) break;
        }

        return res;
    }
}