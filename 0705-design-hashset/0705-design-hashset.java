class MyHashSet {

    boolean[] hashTable;
    
    public MyHashSet() {
        this.hashTable = new boolean[1000001];
    }
    
    public void add(int key) {
        hashTable[key] = true;
    }
    
    public void remove(int key) {
        hashTable[key] = false;
    }
    
    public boolean contains(int key) {
        return hashTable[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */