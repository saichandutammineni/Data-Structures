class Node{
    int val;
    int min;
    Node next;

    Node(int val, int min, Node top){
        this.val=val;
        this.min=min;
        this.next=top;
    }
}

class MinStack {
    Node curr;
    

    public MinStack() {
        curr=null;
    }
    
    public void push(int value) {
        if(curr==null){
            curr=new Node(value, value, null);
        }
        else{
            Node temp=new Node(value, Math.min(value, curr.min),curr);
            curr=temp;
        }
    }
    
    public void pop() {
        curr=curr.next;
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