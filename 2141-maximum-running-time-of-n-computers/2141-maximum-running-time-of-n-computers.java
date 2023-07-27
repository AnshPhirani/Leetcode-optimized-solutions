class Solution {

    public long maxRunTime(int n, int[] batteries) {

        long sumPower = 0;
        for (int power: batteries) {
            sumPower += power;
        }

        long left = 0, right = sumPower/n;
        while(left < right){
            long target = right - (right-left)/2;
            long extra = 0;
            for(int power : batteries) extra += Math.min(power, target);
            
            if(extra >= target*n) left = target;
            else right = target-1;
        }
        
        return left;
    }
}
