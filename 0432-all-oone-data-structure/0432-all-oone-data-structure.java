class Node{
    int freq;
    String key;
    Node next, prev;
    
    public Node(String key, int freq){
        this.key = key;
        this.freq = freq;
    }
}

class AllOne {

    Map<String, Node> map;
    Node head, tail;
    
    public AllOne() {
        map = new HashMap<>();
    }
    
    public void inc(String key) {
        if(!map.containsKey(key)){
            Node newNode = new Node(key, 1);
            addFirst(newNode);
            map.put(key, newNode);
        }
        else{
            Node curNode = map.get(key);
            curNode.freq += 1;
            moveForward(curNode);
        }
        // print();
    }
    
    public void dec(String key) {
        Node curNode = map.get(key);
        curNode.freq -= 1;
        if(curNode.freq == 0){
            deleteNode(curNode);
            map.remove(key);
        }
        else{
            moveBackward(curNode);
        }
        // print();
    }
    
    public String getMaxKey() {
        if(tail == null) return "";
        return tail.key;
    }
    
    public String getMinKey() {
        if(head == null) return "";
        return head.key;
    }
    
    private void addFirst(Node newNode){
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    
    private void deleteNode(Node curNode){
        if(curNode.prev == null){
            
        }
        if(curNode.prev != null){
            curNode.prev.next = curNode.next;    
        }
        else{
            head = curNode.next;
            if(head != null) head.prev = null;
        }
        
        if(curNode.next != null){
            curNode.next.prev = curNode.prev;    
        }
        else{
            tail = curNode.prev;
            if(tail != null) tail.next = null;
        }
        
    }
    
    private void moveForward(Node curNode){
        
        while(curNode.next != null && curNode.freq > curNode.next.freq){
            // System.out.println("forward");
             swapAdjacent(curNode, curNode.next);
        }
    }
    
    private void moveBackward(Node curNode){
        while(curNode.prev != null && curNode.freq < curNode.prev.freq){
            // System.out.println("backward");
            swapAdjacent(curNode.prev, curNode);
        }
    }
    
    private void swapAdjacent(Node first, Node second){
        first.next = second.next;
        second.prev = first.prev;
        second.next = first;
        first.prev = second;
        if(first.next != null){
            first.next.prev = first;
        }
        else{
            tail = first;
        }
        if(second.prev != null){
            second.prev.next = second;
        }
        else{
            head = second;
        }
    }
    
    private void print(){
        Node temp = head;
        while(temp != null){
            System.out.print("[" + temp.key + " = " + temp.freq + "]");
            temp = temp.next;
        }
        System.out.println();
    }
    
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */