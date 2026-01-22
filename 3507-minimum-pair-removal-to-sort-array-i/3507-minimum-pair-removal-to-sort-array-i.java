class Solution {
    public int minimumPairRemoval(int[] nums) {
        int operations = 0;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        while(!isIncreasing(list)){
            int minSum = Integer.MAX_VALUE;
            int minSumIdx = -1;
            for(int idx = 1; idx < list.size(); idx++){
                int curSum = list.get(idx-1) + list.get(idx);
                if(curSum < minSum){
                    minSum = curSum;
                    minSumIdx = idx-1;
                }
            }

            List<Integer> updatedList = new ArrayList<>();
            for(int idx = 0; idx < list.size(); idx++){
                if(idx == minSumIdx){
                    updatedList.add(list.get(idx)+list.get(idx+1));
                    idx++;
                }
                else{
                    updatedList.add(list.get(idx));
                }
            }

            operations++;
            list = updatedList;
        }

        return operations;
    }

    private boolean isIncreasing(List<Integer> list){
        for(int idx = 1; idx < list.size(); idx++){
            if(list.get(idx) < list.get(idx-1)) return false;
        }
        return true;
    }
}