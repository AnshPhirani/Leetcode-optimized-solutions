class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int i = 0, j = 0;
        long maxScore = 0;
        long firstSum = 0, secondSum = 0;
        int mod = (int)1e9+7;
        
        while(i < n && j < m){
            if(nums1[i] == nums2[j]){
                maxScore += nums1[i] + Math.max(firstSum, secondSum);
                maxScore %= mod;
                firstSum = secondSum = 0;
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]){
                firstSum += nums1[i++];
            }
            else{
                secondSum += nums2[j++];
            }
        }
        
        while(i < n) firstSum += nums1[i++];
        while(j < m) secondSum += nums2[j++];
        
        maxScore += Math.max(firstSum, secondSum);
        maxScore %= mod;
        return (int)maxScore;
    }
}