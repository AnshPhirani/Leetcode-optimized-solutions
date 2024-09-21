class Solution {
    public List<Integer> lexicalOrder(int n) {
        Stack<Integer> st = new Stack<>();
        for(int i = 9; i >= 1; i--) st.push(i);
        
        List<Integer> res = new ArrayList<>();
        while(!st.isEmpty()){
            int cur = st.pop();
            if(cur <= n) res.add(cur);
            for(int i = 9; i >= 0; i--){
                int next = cur*10 + i;
                if(next <= n) st.push(next);
            }
        }
        return res;
    }
}