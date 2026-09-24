class Solution {
    private int solve(int[] nums, Integer[][] dp, int i, int p){
        if(i==nums.length) return 0;
        if(dp[i][p]!=null) return dp[i][p];

        int temp=0;
        if(p==0)
        temp=Math.max(1+solve(nums, dp, i+1, i+1), solve(nums, dp, i+1, p));
        else{
            if(nums[i]>nums[p-1]){
                temp=Math.max(1+solve(nums, dp, i+1, i+1), solve(nums, dp, i+1, p));
            }
            else{
                temp=solve(nums, dp, i+1, p);
            }
        }
        return dp[i][p]=temp;
        
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        Integer[][] dp=new Integer[n][n+1];

        return solve(nums, dp, 0, 0);
    }
}