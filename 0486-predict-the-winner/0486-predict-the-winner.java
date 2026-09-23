class Solution {
    private int solve(int[] nums, Integer[][] dp, int i, int j){
        if(dp[i][j]!=null) return dp[i][j];
        if(i==j) return nums[i];

        return dp[i][j]=Math.max(nums[i]-solve(nums, dp, i+1, j), nums[j]-solve(nums, dp, i, j-1));
    }
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        if((n&1)==0){
            return true;
        } 

        Integer[][] dp=new Integer[n][n];

        return solve(nums, dp, 0, n-1)>=0; 
    }
}