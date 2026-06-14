class MyCircularDeque {
    int[] arr;
    int cap, front, rear, size; //capacity
    public MyCircularDeque(int k) {
        // can be done with doubly linked list or a circular array
        arr=new int[k];
        cap=k;
        front=0;
        rear=0;
        size=0;
    }
    
    public boolean insertFront(int value) {
        if(size!=cap){
        
        front=(front-1+cap)%cap; // move and then insert
        arr[front]=value;
        size++;
        return true;
        }
        
        return false;
    }
    
    public boolean insertLast(int value) {
        if(size!=cap){
        arr[rear]=value; // insert and then move
        rear=(rear+1)%cap;
        size++;
        return true;
        }
        
        return false;
    }
    
    public boolean deleteFront() {
        if(size!=0){
            front=(front+1)%cap;
            size--;
            return true;
        }
        return false;
    }
    
    public boolean deleteLast() {
        if(size!=0){
            rear=(rear-1+cap)%cap;
            size--;
            return true;
        }
        return false;
    }
    
    public int getFront() {
        if(size!=0)
        return arr[front];
        else return -1;
    }
    
    public int getRear() {
        if(size!=0)
        return arr[(rear-1+cap)%cap];
        else return -1;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==cap;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */