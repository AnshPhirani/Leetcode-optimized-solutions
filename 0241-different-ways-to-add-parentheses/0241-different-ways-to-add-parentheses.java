class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        if(expression.length() == 1) {
            return List.of(expression.charAt(0)-'0');
        }
        else if(expression.length() == 2){
            return List.of((expression.charAt(0)-'0')*10 + (expression.charAt(1)-'0'));
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < expression.length(); i++){
            char ch = expression.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*'){
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                for(int l : left){
                    for(int r : right){
                        if(ch == '+') res.add(l+r);
                        else if(ch == '-') res.add(l-r);
                        else res.add(l*r);
                    }
                }
            }
        }
        return res;
    }
}