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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=new ListNode(-1);
        ListNode h1=l1, h2=l2, h3=res;
        
        int carry=0;
        while(h1!=null || h2!=null || carry==1){
            int sum=carry;
            if(h1!=null){
                sum+=h1.val;
                h1=h1.next;
            }
            if(h2!=null){
                sum+=h2.val;
                h2=h2.next;
            }
            if(sum>9){
                carry=1;
                sum=sum%10;
            }
            else{
                carry=0;
            }

            ListNode temp=new ListNode(sum);
            h3.next=temp;
            h3=h3.next;
        }

        return res.next;
    }
}