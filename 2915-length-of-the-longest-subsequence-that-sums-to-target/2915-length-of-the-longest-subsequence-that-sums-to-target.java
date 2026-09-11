class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n=nums.size();

        int[] dp=new int[target+1];
        for(int i=1;i<target+1;i++) dp[i]=-1;
        
        for(int j=0;j<n;j++){
            for(int i=target;i>=nums.get(j);i--){
                if(dp[i-nums.get(j)]!=-1){
                    dp[i]=Math.max(dp[i], 1+dp[i-nums.get(j)]);
                }
            }
        }

        return dp[target];
    }
}