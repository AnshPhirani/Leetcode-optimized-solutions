class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        List<List<Integer>> res = new ArrayList<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        pq.add(new int[]{nums1[0] + nums2[0], 0, 0});
        
        Set<String> visited = new HashSet<>();
        visited.add(0+"*"+0);
        
        while(!pq.isEmpty() && k-- > 0){

            int[] cur = pq.poll();
            int i = cur[1], j = cur[2];
            res.add(List.of(nums1[i], nums2[j]));

            if(i+1 < n && !visited.contains(i+1+"*"+j)){
                int[] next = new int[]{nums1[i+1] + nums2[j], i+1, j};
                pq.add(next);
                visited.add(i+1+"*"+j);
            }
            if(j+1 < m && !visited.contains(i+"*"+(j+1))){
                int[] next = new int[]{nums1[i] + nums2[j+1], i, j+1};
                pq.add(next);
                visited.add(i+"*"+(j+1));
            }
        }
        
        return res;
    }
}