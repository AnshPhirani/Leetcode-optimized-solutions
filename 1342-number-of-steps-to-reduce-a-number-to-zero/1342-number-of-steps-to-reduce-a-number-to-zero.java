class Solution {
    public int numberOfSteps(int num) {
        if(num == 0) return 0;
        return 1 + (num%2 == 0 ?  numberOfSteps(num/2) : numberOfSteps(num-1));
    }
}