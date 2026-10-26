class Solution {

    private int solve(int[] nums, Integer[][] dp, int[][] ways, int prev, int curr){
        if(curr==nums.length){
            return 0;
        }

        if(dp[prev+1][curr]!=null) return dp[prev+1][curr];
        int skip=0, take=0, takeways=0;

        skip=solve(nums, dp, ways, prev, curr+1);
        int skipWays=(curr+1==nums.length) ? 1 : ways[prev+1][curr+1];

        if(prev==-1 || nums[curr]>nums[prev]){
            take=1+solve(nums, dp, ways, curr, curr+1);
            takeways=(curr+1==nums.length) ? 1 : ways[curr+1][curr+1];
        }
        
        if(skip>take){
            ways[prev+1][curr]=skipWays;
        }
        else if(take>skip){
            ways[prev+1][curr]=takeways;
        }
        else{
            ways[prev+1][curr]=skipWays+takeways;
        }
        
        return dp[prev+1][curr]=Math.max(skip, take);
    }
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        Integer[][] dp=new Integer[n+1][n+1];
        int[][] waysdp=new int[n+1][n+1];
        for(int[] i: waysdp) Arrays.fill(i, 0);
        solve(nums, dp, waysdp, -1, 0);


        return waysdp[0][0];
    }
}