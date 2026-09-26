class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+1][n+1];

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                if(j==0){
                    dp[i][j]=Math.max(dp[i+1][i+1]+1, dp[i+1][j]);
                }
                else{
                if(nums[i]>nums[j-1])
                dp[i][j]=Math.max(dp[i+1][i+1]+1, dp[i+1][j]);
                else
                dp[i][j]=dp[i+1][j];
                }
            }
        }

        return dp[0][0];
    }
}