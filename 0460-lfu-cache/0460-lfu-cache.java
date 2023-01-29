class Node{
    int key, value, freq;
    Node next, prev;
    
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

class DoublyLinkedList {
    Node head, tail;
    int size;

    public DoublyLinkedList() {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.head.prev = null;
        this.tail.prev = head;
        this.tail.next = null;
    }

    public void addNode(Node node) {
        size++;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void removeNode(Node node) {
        size--;
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}



class LFUCache {
    private int capacity, size, minFreq;
    private Map<Integer, DoublyLinkedList> freqListMap;
    private Map<Integer, Node> keyNodeMap;
    
    public LFUCache(int capacity) {
        this.freqListMap = new HashMap<>();
        this.keyNodeMap = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
    }
    
    public int get(int key) {
        if(!keyNodeMap.containsKey(key)) return -1;
        Node curNode = keyNodeMap.get(key);
        updateNode(curNode);
        return curNode.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.value = value;
            updateNode(node);
        } else {
            Node newNode = new Node(key, value);
            if (size == capacity) {
                DoublyLinkedList frequencyList = freqListMap.get(minFreq);
                keyNodeMap.remove(frequencyList.tail.prev.key);
                frequencyList.removeNode(frequencyList.tail.prev);
                size--;
            }
            size++;
            minFreq = 1;
            DoublyLinkedList newList = freqListMap.getOrDefault(1, new DoublyLinkedList());
            newList.addNode(newNode);
            keyNodeMap.put(key, newNode);
            freqListMap.put(1, newList);
        }
        
    }
    
    private void updateNode(Node node){
        DoublyLinkedList curList = freqListMap.get(node.freq);
        curList.removeNode(node);
        
        if(node.freq == minFreq && curList.size==0) minFreq++;
        node.freq += 1;
        
        freqListMap.putIfAbsent(node.freq, new DoublyLinkedList());
        DoublyLinkedList nextList = freqListMap.get(node.freq);
        nextList.addNode(node);   
    }
    
    
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */