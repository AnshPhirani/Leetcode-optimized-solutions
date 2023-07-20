class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        
        for(int asteroid : asteroids){
            if(asteroid > 0){
                st.push(asteroid);
            }
            else{
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < -asteroid){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() > 0){
                    if(st.peek() == -asteroid) st.pop();
                    continue;
                }
                st.push(asteroid);
            }
        }
        
        int[] res = new int[st.size()];
        int k = st.size()-1;
        while(!st.isEmpty()) res[k--] = st.pop();
        return res;
    }
}