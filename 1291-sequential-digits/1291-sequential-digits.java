class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> que = new LinkedList<>();
        for(int i = 1; i <= 9; i++){
            que.add(i);
        }
        
        List<Integer> ans = new ArrayList<>();
        
        while(!que.isEmpty()){
            int curNum = que.poll();
            if(curNum >= low && curNum <= high) ans.add(curNum);
            
            int nextDigit = curNum%10+1;
            if(nextDigit > 9) continue;
            int nextNum = curNum*10 + nextDigit;
            if(nextNum <= high) que.add(nextNum);             
        }
        
        return ans;
        
    }
}