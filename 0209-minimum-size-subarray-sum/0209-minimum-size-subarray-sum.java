class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        int ans=Integer.MAX_VALUE, sum=0;
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            dq.offerLast(i);
            
            while(sum>=target){
                ans=Math.min(ans, dq.peekLast()-dq.peekFirst()+1);
                sum-=nums[dq.pollFirst()];
            }

            


        }

        return ans==Integer.MAX_VALUE ? 0 : ans;
    }
}