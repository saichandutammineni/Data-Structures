

class LRUCache {

    class Node{
        int val;
        Node next, prev;

        Node(int val){
            this.val=val;
            this.next=null;
            this.prev=null;
        }
    }

    HashMap<Integer, Integer> hm=new HashMap<>();
    int capacity=0;

    Node head=new Node(-1), last=head;
    HashMap<Integer, Node> nodeTrack=new HashMap<>();
    public LRUCache(int capacity) {
        // HashMap<Integer, Integer> hm=new HashMap<>();
        this.capacity=capacity;
    }
    
    public int get(int key) {

        if(hm.containsKey(key)){
            updateKey(key);
            return hm.get(key);
        }
        else{
            return -1;
        }
        
    }

    public void updateKey(int key){
        Node t=nodeTrack.get(key);
        if(t.next!=null){
        Node t1=t.next;
        Node tprev=t.prev;
        tprev.next=t1;
        t1.prev=tprev;
        t.next=null;
        last.next=t;
        t.prev=last;
        last=t;
        }
    }
    
    public void put(int key, int value) {
        if(!hm.containsKey(key)){
            Node t=new Node(key);
            nodeTrack.put(key, t);
            last.next=t;
            t.prev=last;
            last=t;
            if(hm.size()==capacity){
                Node h1=head.next;

                head.next=h1.next;
                if(h1.next!=null){
                    
                    h1.next.prev=head;
                }
                h1.prev=null;
                h1.next=null;
                hm.remove(h1.val);
                nodeTrack.remove(h1.val);
            }

        }
        else{
            updateKey(key);
        }
        hm.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */