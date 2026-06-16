class Solution {
    public int maxResult(int[] nums, int k) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];

        ArrayDeque<Integer> q=new ArrayDeque<>();
        q.offer(0);
        for(int i=1;i<nums.length;i++){
            if(!q.isEmpty() && q.peekFirst()<i-k){
                q.pollFirst();
            }

            dp[i]=nums[i]+dp[q.peekFirst()];
            while(!q.isEmpty() && dp[q.peekLast()]<dp[i]){
                q.pollLast();
            }

            q.offer(i);

        }
        return dp[nums.length-1];
    }
}