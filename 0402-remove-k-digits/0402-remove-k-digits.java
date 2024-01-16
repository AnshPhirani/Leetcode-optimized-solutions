class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(char digit : num.toCharArray()){
            while(!st.isEmpty() && st.peek() > digit && k > 0){
                st.pop();
                k--;
            }
            st.push(digit);
        }
        
        StringBuilder sb = new StringBuilder("");
        while(!st.isEmpty()) sb.append(st.pop());
        sb.reverse();
        
        int idx = 0;
        while(idx < sb.length() && sb.charAt(idx) == '0'){
            idx++;
        }
        if(k >= sb.length()-idx) return "0";
        String ans = sb.substring(idx, sb.length()-k).toString();
        return ans;
        
    }
}