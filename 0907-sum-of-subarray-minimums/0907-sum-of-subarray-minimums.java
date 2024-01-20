class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        
        int[] rightSmaller = new int[n];
        Arrays.fill(rightSmaller, n-1);
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                rightSmaller[st.pop()] = i-1;
            }
            st.push(i);
        }
        
        st.clear();
        int[] leftSmaller = new int[n];
        Arrays.fill(leftSmaller, 0);
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                leftSmaller[st.pop()] = i+1;
            }
            st.push(i);
        }
        
//         System.out.println(Arrays.toString(leftSmaller));
//         System.out.println(Arrays.toString(rightSmaller));
        
        long ans = 0;
        int MOD = (int)1e9 + 7;
        for(int i = 0; i < n; i++){
            ans += 1l * arr[i] * (i-leftSmaller[i]+1)*(rightSmaller[i]-i+1);
            ans %= MOD;
        }
        return (int)(ans);
    }
}