class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        List<List<Integer>> ans = new ArrayList();
        
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Set<Integer> common = new HashSet<>();
        
        for(int num : nums2) s2.add(num);
        for(int num : nums1) s1.add(num);
        for(int val : s1) if(s2.contains(val)) common.add(val);
        
        s1.removeAll(common);
        s2.removeAll(common);
        
        ans.add(new ArrayList<>(s1));
        ans.add(new ArrayList<>(s2));
        
        return ans;
    }
}