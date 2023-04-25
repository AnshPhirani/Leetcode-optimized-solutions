class SmallestInfiniteSet {
    private Set<Integer> set;
    private int k;
    
    public SmallestInfiniteSet() {
        this.k = 1;
        this.set = new HashSet<>();
    }
    
    public int popSmallest() {
        if(set.isEmpty()) return k++;
        int min = Collections.min(set);
        set.remove(min);
        return min;
        
    }
    
    public void addBack(int num) {
        if(k > num) set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */