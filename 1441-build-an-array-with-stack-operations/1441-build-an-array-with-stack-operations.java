class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int curVal = 1;
        int idx = 0;
        while(idx < target.length){
            int targetVal = target[idx];
            if(curVal == targetVal){
                operations.add("Push");
                curVal++;
                idx++;
            }
            else{
                operations.add("Push");
                operations.add("Pop");
                curVal++;
            }
        }
        
        return operations;
        
    }
}