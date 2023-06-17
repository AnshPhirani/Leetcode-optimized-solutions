class Solution {
    
    Map<String, Integer> memo;
    
    private int upperBound(int val, int[] arr){
        int l = 0, h = arr.length-1;
        int ans = -1;
        while(l <= h){
            int mid = (l+h)/2;
            if(arr[mid] <= val){
                l = mid+1;
            }
            else{
                h = mid-1;
                ans = arr[mid];
            }
        }
        
        return ans;
    }
    
    private int helper(int idx, int prevVal, int[] arr1, int[] arr2){
        if(idx == arr1.length) return 0;
        
        String key = idx + "*" + prevVal;
        if(memo.containsKey(key)) return memo.get(key);
        
        int curOperations = 999999;
        
        // do not replace current value
        if(arr1[idx] > prevVal){
            curOperations = Math.min(curOperations, helper(idx+1, arr1[idx], arr1, arr2));
        }
        
        // replace current value
        int replacingValue = upperBound(prevVal, arr2);
        if(replacingValue != -1)
            curOperations = Math.min(curOperations, 1 + helper(idx+1, replacingValue, arr1, arr2));
        
        memo.put(key, curOperations);
        return memo.get(key);
    }
    
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        
        Set<Integer> set = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
        
        arr2 = new int[set.size()];
        int idx = 0;
        for(int ele : set) arr2[idx++] = ele;
        Arrays.sort(arr2);
        
        this.memo = new HashMap<>();
        int ans = helper(0, Integer.MIN_VALUE, arr1, arr2);
        return ans >= 999999 ? -1 : ans;
    }
}