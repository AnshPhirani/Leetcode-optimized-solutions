class SnapshotArray {

    private int snapId;
    private Map<Integer, Integer>[] map;
    
    public SnapshotArray(int length) {
        this.snapId = 0;
        this.map = new HashMap[length];
        for(int idx = 0; idx < length; idx++){
            map[idx] = new HashMap<>();
        }
    }
    
    public void set(int index, int val) {
        map[index].put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        while(!map[index].containsKey(snap_id)){
            snap_id--;
            if(snap_id == -1) return 0; 
        }
        
        return map[index].get(snap_id);
        
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */