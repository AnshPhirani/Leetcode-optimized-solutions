class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b )-> a.getKey()-b.getKey());
        for(int i = 0; i < n; i++){
            pq.add(new Pair<>(nums[i], i));
            if(pq.size() > k) pq.poll();
        }

        boolean[] selected = new boolean[n];
        while(!pq.isEmpty()) selected[pq.poll().getValue()] = true;

        int[] ans = new int[k];
        int idx = 0;
        for(int i = 0; i < n; i++){
            if(selected[i]) ans[idx++] = nums[i];
        }
        return ans;


    }
}