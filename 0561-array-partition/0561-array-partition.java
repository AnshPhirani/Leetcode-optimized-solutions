class Solution {
    public int arrayPairSum(int[] nums) {
        int[] count = new int[10000+10001];
        for(int num : nums){
            num += 10000;
            count[num]++;
        }
        
        int num = 0;
        int sum = 0;
        boolean flag = true;
        while(num < count.length){
            if(count[num] > 0){
                if(flag) sum += num-10000;
                flag = !flag;
                count[num]--;
            }
            else{
                num++;
            }
        }
        return sum;
    }
}