class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3) return 0;
        int n=nums.length;
        int[][] dp=new int[n][n];

        int res=0;
        for(int i=0;i<n-2;i++){
            for(int j=i+2;j<n;j++){
                if(j-i==2){
                    if(nums[j]-nums[j-1]==nums[j-1]-nums[i]){
                        dp[i][j]=1;
                        res++;
                    }
                }
                else if(dp[i][j-1]==1){
                    if(nums[j]-nums[j-1]==nums[i+1]-nums[i]){
                        dp[i][j]=1;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}