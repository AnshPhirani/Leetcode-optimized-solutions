class Solution {

    private void generate(int cur, int n, List<Integer> numbers){
        if(cur > n) return; 
        numbers.add(cur);
        for(int i = 0; i <= 9; i++){
            generate(cur*10 + i, n, numbers);
        }
    }
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            generate(i, n, numbers);
        }
        return numbers;
    }
}