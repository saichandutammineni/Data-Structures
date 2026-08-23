class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        return Math.max(solve(nums, 0, n-2), solve(nums, 1, n-1));
    }

    private int solve(int[] nums, int start, int end){
        if(end==start) return nums[start];
        int[] dp=new int[nums.length];
        dp[end]=nums[end];
        dp[end-1]=Math.max(dp[end],nums[end-1]);
        for(int i=end-2;i>=start;i--){
            dp[i]=Math.max(nums[i]+dp[i+2], dp[i+1]);
        }

        return dp[start];
    }
}