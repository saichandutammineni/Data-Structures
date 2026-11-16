class Node{
    int val;
    Node next;

    Node(int val){
        this.val=val;
    }
}

class Solution {
    private int findMax(int[] arr){
        int max=0;
        for(int i:arr){
            max=Math.max(max, i);
        }
        return max;
    }
    public int getWinner(int[] arr, int k) {
        int n=arr.length;

        if(n<=k || n<3){
            return findMax(arr);
        }

        Node head=new Node(-1);
        Node tail=head;
        for(int i:arr){
            tail.next=new Node(i);
            tail=tail.next;
        }

        int currk=0, prev=0;
        while(currk<k){
            int currWinner=0;
            if(head.next.val>head.next.next.val){
                currWinner=head.next.val;
                Node t=head.next.next;
                head.next.next=t.next;
                tail.next=t;
                tail=tail.next;
                t.next=null;
            }
            else{
                currWinner=head.next.next.val;
                Node t=head.next;
                head.next=t.next;
                tail.next=t;
                tail=tail.next;
                t.next=null;
            }

            if(prev==currWinner){
                currk++;
            }
            else{
                prev=currWinner;
                currk=1;
            }
        }

        return head.next.val;
    }
}