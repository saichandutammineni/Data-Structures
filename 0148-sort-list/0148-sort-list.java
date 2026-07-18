/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    private ListNode merge(ListNode left, ListNode right, ListNode prev){
        
        while(left!=null && right!=null){
            if(left.val<right.val){
                prev.next=left;

                left=left.next;
                prev=prev.next;
                prev.next=null;
            }
            else{
                prev.next=right;
                right=right.next;
                prev=prev.next;
                prev.next=null;
            }
        }

        if(left!=null) prev.next=left;
        if(right!=null) prev.next=right;
        while(prev.next!=null) prev=prev.next;
        return prev;
    }

    private ListNode split(ListNode head, int step){
        if(head==null) return null;

        for(int i=1;i<step && head.next!=null; i++){
            head=head.next;
        }
        ListNode temp=head.next;
        head.next=null;
        return temp;
    }
    public ListNode sortList(ListNode head) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        int n=0;
        while(head!=null){
            head=head.next;
            n++;
        }

        for(int step=1;step<n;step*=2){
            ListNode next=dummy.next;
            ListNode prev=dummy;
            ListNode left, right;
            while(next!=null){
                left=next;
                right=split(left, step);
                next=split(right, step);

                prev=merge(left, right, prev);
            }
        }

        return dummy.next;
    }
}