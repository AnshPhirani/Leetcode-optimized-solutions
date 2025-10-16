class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            num = num%value;
            if(num < 0) num += value;
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(int mex = 0; mex < nums.length; mex++){
            if(map.containsKey(mex)){
                map.put(mex, map.get(mex)-1);
                if(map.get(mex) == 0) map.remove(mex);
            }
            else{
                if(map.containsKey(mex%value)){
                    map.put(mex%value, map.get(mex%value)-1);
                    if(map.get(mex%value) == 0) map.remove(mex%value);
                }
                else{
                    return mex;
                }
            }
        }

        return nums.length;
    }
}