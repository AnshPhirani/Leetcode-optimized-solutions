class SmallestInfiniteSet {
    private TreeSet<Integer> set;
    private int k;
    public SmallestInfiniteSet() {
        this.k = 1;
        this.set = new TreeSet<>();
    }
    
    public int popSmallest() {
        if(set.isEmpty()) return k++;
        if(k == set.first()){
            set.pollFirst();
            return k++;
        }
        return k < set.first() ? k++ : set.pollFirst();
    }
    
    public void addBack(int num) {
        set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */