class Solution {
    public int maxResult(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> Integer.compare(b[0], a[0]));

        pq.add(new int[]{nums[n-1], n-1});

        for(int i=n-2;i>=0;i--){
            while(!pq.isEmpty() && pq.peek()[1]-i>k){
                pq.poll();
            }
            
            pq.offer(new int[]{pq.peek()[0]+nums[i], i});
            
        }
        while(!pq.isEmpty()){
            if(pq.peek()[1]==0){
                return pq.peek()[0];
            }
            else{
                pq.poll();
            }
        }
        return pq.peek()[0];
    }
}