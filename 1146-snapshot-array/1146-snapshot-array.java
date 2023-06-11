class SnapshotArray {

    private int snapId;
    private TreeMap<Integer, Integer>[] map;
    
    public SnapshotArray(int length) {
        this.snapId = 0;
        this.map = new TreeMap[length];
        for(int idx = 0; idx < length; idx++){
            map[idx] = new TreeMap<>();
        }
    }
    
    public void set(int index, int val) {
        map[index].put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        Integer key = map[index].floorKey(snap_id);
        if(key == null) return 0;
        return map[index].get(key);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */