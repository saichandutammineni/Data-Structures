class Solution {
    private int solve(int[] dp, int[] nums, int index){
        if(index>=nums.length) return 0;
        if(dp[index]!=-1) return dp[index];

        return dp[index]=Math.max(nums[index]+solve(dp, nums, index+2), solve(dp, nums, index+1));
    }
    public int rob(int[] nums) {
        
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp=new int[n];
        
        Arrays.fill(dp, -1);
        
        int temp=nums[n-1];
        
        int a=solve(dp, nums, 1);
        nums[n-1]=0;
        Arrays.fill(dp, -1);
        return Math.max(a, nums[0]+solve(dp, nums, 2));
    }
}