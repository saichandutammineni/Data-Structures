class Node{
    int val;
    int min;
    Node next, front;

    Node(int val, int min){
        this.val=val;
        this.min=min;
        this.next=null;
        this.front=null;
    }
}

class MinStack {
    Node head, curr;
    

    public MinStack() {
        head=new Node(0, Integer.MAX_VALUE);
        curr=head;
    }
    
    public void push(int value) {
        
        Node temp=new Node(value, Math.min(value, curr.min));
        curr.next=temp;
        temp.front=curr;
        curr=temp;
        
    }
    
    public void pop() {
        Node temp=curr;
        
        curr=curr.front;
        curr.next=null;
        temp.front=null;
    }
    
    public int top() {
        return curr.val;
    }
    
    public int getMin() {
        return curr.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */