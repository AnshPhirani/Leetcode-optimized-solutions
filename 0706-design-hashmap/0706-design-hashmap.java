class MyHashMap {
    Integer[] table;
    
    public MyHashMap() {
        this.table = new Integer[1000001];    
    }
    
    public void put(int key, int value) {
        table[key] = value;        
    }
    
    public int get(int key) {
        return table[key] == null ? -1 : table[key];
    }
    
    public void remove(int key) {
        table[key] = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */