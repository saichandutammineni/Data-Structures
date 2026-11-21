class Node{
    int val;
    int index;
    Node(int val, int index){
        this.val=val;
        this.index=index;
    }
}

class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Node> pq=new PriorityQueue<Node>((a,b)-> Integer.compare(b.val, a.val));
        for(int i=0;i<score.length;i++){
            pq.offer(new Node(score[i], i));
        }

        String[] ans=new String[score.length];
        int j=0;
        if(!pq.isEmpty()){
            Node temp=pq.poll();
            ans[temp.index]="Gold Medal";
        }
        if(!pq.isEmpty()){
            Node temp=pq.poll();
            ans[temp.index]="Silver Medal";
        }
        if(!pq.isEmpty()){
            Node temp=pq.poll();
            ans[temp.index]="Bronze Medal";
            j=4;
        }
        while(!pq.isEmpty()){
            Node temp=pq.poll();
            ans[temp.index]=(j++)+"";
        }

        return ans;
    }
}