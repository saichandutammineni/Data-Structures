/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        //if(head.next==null) return new Node()
        Node h=head, h1=head, n2=null;
        while(h!=null){
            Node temp=new Node(h.val);
            h1=h.next;
            h.next=temp;
            temp.next=h1;
            h=temp.next;
        }

        h=head;
        while(h!=null){
            Node temp=h.random;
            if(temp!=null){
                h.next.random=temp.next;
            }
            else{
                h.next.random=n2;
            }
            // if(h.next!=null)
            h=h.next.next;
        }

        h=head;
        h1=head.next;
        Node res=h1;
        while(h1.next!=null){
            h.next=h.next.next;
            h=h.next;
            h1.next=h1.next.next;
            h1=h1.next;
        }
        h.next=h1.next;
        h1.next=n2;
        return res;


    }
}