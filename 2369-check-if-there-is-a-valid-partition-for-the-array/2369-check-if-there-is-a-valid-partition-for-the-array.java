class Solution {
    private int solve(int[] nums, int index, int[] dp){
        if(index==nums.length){
            return 1;
        }
        if(index==nums.length-1) return 0;
        if(dp[index]!=-1) return dp[index];
        int res=0;

        if(index+1<nums.length){
            if(nums[index]==nums[index+1]){
                res |=  solve(nums, index+2, dp);
            }
            
        }
        if(index+2<nums.length){
            if(nums[index]==nums[index+1] && nums[index]==nums[index+2]){
                res|=solve(nums, index+3, dp);
            }
            else if(nums[index]+1==nums[index+1] && nums[index+1]+1==nums[index+2]){
                res|=solve(nums, index+3, dp);
            }
        }
        return dp[index]=res;


    }
    public boolean validPartition(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, 0, dp)==1;
    }
}