class Node{
    int index;
    int val;

    public Node(int val, int index){
        this.val=val;
        this.index=index;
    }
}

class Solution {
    public long totalCost(int[] costs, int k, int cand) {
        long cost=0;
        int n=costs.length;
        int l=cand-1, r=n-cand > l ? n-cand : Math.min(l+1, n);
       // boolean[] used=new boolean[n];
        
        PriorityQueue<Node> minHeap=new PriorityQueue<>((a,b)->{
            if(a.val!=b.val) return a.val-b.val;
            else return a.index-b.index;
        });
        for(int i=0;i<=l;i++){
            minHeap.offer(new Node(costs[i], i));
        }

        for(int i=r;i<n;i++){
            minHeap.offer(new Node(costs[i], i));
        }

        while(!minHeap.isEmpty() && k-->0){
            Node temp=minHeap.poll();
            cost+=temp.val;

            if(temp.index<=l){
                if(l+1<r && l+1<n){
                    l++;
                    minHeap.offer(new Node(costs[l], l));
                }
            }
            else if(temp.index>=r){
                if(r-1>l && r-1>=0){
                    r--;
                    minHeap.offer(new Node(costs[r], r));
                }
            }
        }

        return cost;
        
    }
}