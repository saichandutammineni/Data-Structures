class Solution {
    private int solve(int[][] dp, List<Integer> nums, int index, int target){
        if(target==0){
            return 0;
        }
        else if(index==nums.size()) return -2;
        else if(dp[index][target]!=-1) return dp[index][target];

        int t=solve(dp,nums, index+1,target);
        int t1=-2;
        if(target>=nums.get(index)){
            int res=solve(dp, nums, index+1, target-nums.get(index));
            if(res!=-2)
                t1=res+1;
        }
        return dp[index][target]=Math.max(t1, t);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp=new int[nums.size()][target+1];

        for(int i=0;i<nums.size();i++) Arrays.fill(dp[i], -1);
        // -1 -> uncomputed, -2 -> impossible state

        int ans=solve(dp,nums, 0, target);
        return ans!=-2 ? ans : -1;
        
    }
}