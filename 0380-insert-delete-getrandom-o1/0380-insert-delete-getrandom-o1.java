class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> li;
  
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.li = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        li.add(val);
        map.put(val, li.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int idx = map.get(val);
        map.remove(val);
        li.set(idx, li.get(li.size()-1));
        li.remove(li.size()-1);
        
        if(idx < li.size()) map.put(li.get(idx), idx);
        
        return true;
        
    }
    
    public int getRandom() {
        Random rand = new Random();
        int idx = rand.nextInt(li.size());
        return li.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */