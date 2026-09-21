class Solution {
    private int solve(Integer[][] dp,  int[] nums, int index, int curr, int target){
        if(index==nums.length){
            if(curr==target) return 1;
            else return 0;
        }

        if(dp[index][curr]!=null){
            return dp[index][curr];
        }

        int temp=0;
        if(curr+nums[index]<=target){
            temp=solve(dp, nums, index+1, curr+nums[index], target);
            temp|=solve(dp, nums, index+1, curr, target);
        }
        else{
            temp=solve(dp, nums, index+1, curr, target);
        }
        return dp[index][curr]=temp;
    }

    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        if(sum%2!=0) return false;
        sum=sum/2;
        Integer[][] dp=new Integer[nums.length][sum+1];
        return solve(dp, nums, 0, 0, sum)== 1;
    }
}