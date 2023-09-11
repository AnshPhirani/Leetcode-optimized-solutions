class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < groupSizes.length; i++){
            int groupSize = groupSizes[i];
            if(!map.containsKey(groupSize)) map.put(groupSize, new ArrayList<>());
            map.get(groupSize).add(i);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int groupSize : map.keySet()){
            List<Integer> li = map.get(groupSize);
            List<Integer> group = new ArrayList<>();
            for(int i = 0; i < li.size(); i++){
                if(i != 0 && i%groupSize == 0){
                    res.add(group);
                    group = new ArrayList<>();
                }
                group.add(li.get(i));
            }
            res.add(group);
        }
        return res;
    }
}