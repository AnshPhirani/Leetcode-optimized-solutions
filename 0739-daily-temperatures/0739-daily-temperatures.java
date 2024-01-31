class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        
        for(int i = 0; i < n; i++){
            int temperature = temperatures[i];
            while(!st.isEmpty() && temperatures[st.peek()] <  temperature){
                ans[st.peek()] = i-st.peek();
                st.pop();
            }
            st.push(i);
        }
        
        return ans;
        
    }
}