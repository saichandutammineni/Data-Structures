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
        Node temp=head;

        while(temp!=null){
            Node copyNode=new Node(temp.val);
            copyNode.next=temp.next;
            temp.next=copyNode;
            temp=copyNode.next;
        }

        temp=head;
        while(temp!=null){
            if(temp.random!=null){
            temp.next.random=temp.random.next;
            }
            temp=temp.next.next;
        }

        Node t1=head;
        Node t2=head.next, newHead=t2;
        Node t3, t4;

        while(t2!=null){
            t3=t2!=null ? t2.next : null;
            t4=t3!=null ? t3.next : null;
            t1.next=t3;
            t2.next=t4;
            t1=t3;
            t2=t4;
        }  


        return newHead;


    }
}