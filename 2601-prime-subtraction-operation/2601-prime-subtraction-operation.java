class Solution {
    public boolean primeSubOperation(int[] nums) {
        List<Integer> primes = new ArrayList<>();
        
        for(int i = 2; i < 1000; i++){
            boolean isPrime = true;
            for(int j = 2; j*j <= i; j++){
                if(i%j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) primes.add(i);
        }
        
        
        for(int idx = 0; idx < nums.length; idx++){
            int prevVal = (idx-1 >= 0) ? nums[idx-1] : 0;
            int curVal = nums[idx];
            if(curVal <= prevVal) return false;
            
            int left = 0, right = primes.size()-1;
            int primeToSubtract = 0;
            while(left <= right){
                int mid = (left+right)/2;
                int prime = primes.get(mid);
                if(curVal < prime) right = mid-1;
                else if(curVal-prime <= prevVal) right = mid-1;
                else {
                    primeToSubtract = prime;
                    left = mid+1;
                }
            }
            
            nums[idx] = curVal-primeToSubtract;
        }
        
        return true;
    }
}



// 2 3 5 7 11 
