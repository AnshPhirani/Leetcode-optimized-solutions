class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n  = arr.length;
        long sum = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        
        for(int idx = 0; idx <= n; idx++){
            int curVal = idx < n? arr[idx] : 0;
            while(st.peek() != -1 && curVal < arr[st.peek()]){
                int middleIdx = st.pop();
                int leftIdx = st.peek();
                int rightIdx = idx;
                sum += 1l*(rightIdx-middleIdx)*(middleIdx-leftIdx)*arr[middleIdx];
                sum %= (int)1e9+7;
            }
            st.push(idx);
        }
        
        return (int)sum;
        
    }
}