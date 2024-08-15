class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch =='B' && !st.isEmpty() && st.peek() == 'A'){
                st.pop();
            }
            else if(ch == 'D' && !st.isEmpty() && st.peek() == 'C'){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        
        return st.size();
        
    }
}