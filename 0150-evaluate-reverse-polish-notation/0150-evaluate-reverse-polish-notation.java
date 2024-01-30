class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token : tokens){
            if(token.equals("+")){
                int second = st.pop();
                int first = st.pop();
                st.push(first+second);
            }
            else if(token.equals("-")){
                int second = st.pop();
                int first = st.pop();
                st.push(first-second);
            }
            else if(token.equals("*")){
                int second = st.pop();
                int first = st.pop();
                st.push(first*second);
            }
            else if(token.equals("/")){
                int second = st.pop();
                int first = st.pop();
                st.push(first/second);
            }
            else{
                st.push(Integer.parseInt(token));
            }  
        }
        
        return st.pop();
    }
}