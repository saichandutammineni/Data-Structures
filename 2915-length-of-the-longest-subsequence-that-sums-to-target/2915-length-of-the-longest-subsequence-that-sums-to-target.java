class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n=nums.size();

        int[] dp=new int[target+1];
        for(int i=1;i<target+1;i++) dp[i]=-1;
        
        for(int num: nums){
            for(int i=target;i>=num;i--){
                if(dp[i-num]!=-1){
                    dp[i]=Math.max(dp[i], 1+dp[i-num]);
                }
            }
        }

        return dp[target];
    }
}