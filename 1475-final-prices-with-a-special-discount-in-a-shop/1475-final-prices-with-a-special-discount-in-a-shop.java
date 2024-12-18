class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < prices.length; i++){
            int curPrice = prices[i];
            while(!st.isEmpty() && prices[st.peek()] >= curPrice){
                prices[st.pop()] -= curPrice;
            }
            st.push(i);
        }
        
        return prices;
        
    }
}