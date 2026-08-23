class Solution {
    private int solve(int[] dp, int[] nums, int index){
        if(index>=nums.length) return 0;
        if(dp[index]!=-1) return dp[index];

        return dp[index]=Math.max(nums[index]+solve(dp, nums, index+2), solve(dp, nums, index+1));
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp=new int[nums.length];
        
        Arrays.fill(dp, -1);

        return solve(dp, nums, 0);
    }
}