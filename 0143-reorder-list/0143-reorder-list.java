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
    private ListNode reverseList(ListNode h){
        if(h==null || h.next==null){
            return h; 
        }

        ListNode h1=h, h2=h.next, h3=null;
        
        while(h2!=null){
            h3=h2.next;
            h2.next=h1;
            h1=h2;
            h2=h3;
        }
        h.next=null;
        return h1;

    }
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode h1=head, h2=head;

        while(h2!=null && h2.next!=null){
            h1=h1.next;
            h2=h2.next.next;
        }

        ListNode mid=h1.next;
        h1.next=null;
        ListNode h3=reverseList(mid); // h1 is mid 
        h1=head;
        

        while(h1!=null && h3!=null){
            h2=h1.next;
            ListNode h4=h3.next;
            h1.next=h3;
            h3.next=h2;
            h1=h2;
            h3=h4;
        }

        return;
    }
}