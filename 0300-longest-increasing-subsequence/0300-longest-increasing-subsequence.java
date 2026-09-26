class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[2][n+1];

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                if(j==0){
                    dp[0][j]=Math.max(dp[1][i+1]+1, dp[1][j]);
                }
                else{
                if(nums[i]>nums[j-1])
                dp[0][j]=Math.max(dp[1][i+1]+1, dp[1][j]);
                else
                dp[0][j]=dp[1][j];
                }
            }
            dp[1]=dp[0];
        }

        return dp[0][0];
    }
}