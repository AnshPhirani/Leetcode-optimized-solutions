class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;

        // for(int i = 1; i*i <= 24; i++){
        //     System.out.println(i);
        // }

        for (int num : nums) {
            int divisorCount = 0, divisorSum = 0;
            for (int i = 1; i * i <= num; i++) {
                // System.out.println(i);
                if (num % i == 0) {
                    divisorCount++;
                    divisorSum += i;

                    int j = num / i;
                    if (i != j) {
                        divisorCount++;
                        divisorSum += j;
                    }
                    if (divisorCount > 4)
                        break;
                }

            }
            if (divisorCount == 4)
                totalSum += divisorSum;
        }
        return totalSum;
    }
}