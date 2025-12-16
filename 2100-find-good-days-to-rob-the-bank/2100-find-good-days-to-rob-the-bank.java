class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] suffixCount = new int[n];
        suffixCount[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1])
                suffixCount[i] = 1 + suffixCount[i + 1];
            else
                suffixCount[i] = 1;
        }

        System.out.println(Arrays.toString(suffixCount));

        List<Integer> ans = new ArrayList<>();
        int prefixCount = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && i < n - 1 && security[i] <= security[i-1]) {
                prefixCount++;
            } else {
                prefixCount = 1;
            }
            if (prefixCount >= time + 1 && suffixCount[i] >= time + 1) {
                ans.add(i);
            }
        }

        return ans;
    }
}