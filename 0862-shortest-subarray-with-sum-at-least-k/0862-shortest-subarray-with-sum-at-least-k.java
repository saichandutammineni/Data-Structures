class Node{
    long sum;
    int index;

    public Node(long sum, int index){
        this.sum=sum;
        this.index=index;
    }
}

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        ArrayDeque<Node> dq=new ArrayDeque<>();
        long sum=0;
        int ans=Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++){
            
            sum+=nums[i];
            while(!dq.isEmpty() && sum-dq.peekFirst().sum>=k){
                ans=Math.min(ans, i-dq.peekFirst().index);
                dq.pollFirst();
            }

            while(!dq.isEmpty() && dq.peekLast().sum>=sum){
                dq.pollLast();
            }


            
            dq.offerLast(new Node(sum, i));
            if(sum>=k){
                ans=Math.min(ans, i+1);
            }
        }

        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}