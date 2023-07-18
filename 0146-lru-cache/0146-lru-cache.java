class ListNode{
    int key, val;
    ListNode next, prev;
    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}


class LRUCache {
    int capacity, size;
    ListNode head, tail;
    Map<Integer, ListNode> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        this.head = new ListNode(-1,1);
        this.tail = new ListNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        removeNode(map.get(key));
        map.remove(key);
        addNodeToLast(key, val);
        return val;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(size == capacity){
                map.remove(head.next.key);
                removeNode(head.next);
            }
            addNodeToLast(key, value);
        }
        else{
            map.get(key).val = value;
            this.get(key);
        }
    }
    
    private void addNodeToLast(int key, int value){
        ListNode newNode = new ListNode(key,value);
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
        this.size++;
        map.put(key, newNode);
    }
    
    private void removeNode(ListNode node){
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
        size--;
    }
    
    private void print(){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */