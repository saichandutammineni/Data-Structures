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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || (head.next==null && n==1)){
            return null;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode front=dummy, curr=dummy;
        
        while(front!=null && front.next!=null){
            front=front.next;
            if(n>0){
                n--;
            }
            else{
                curr=curr.next;
            }
        }
        // if(n>0){
        //     return dummy.next;
        // }
        //if(curr.next!=null){
        curr.next=curr.next.next;
       // }
        return dummy.next;
    }
}