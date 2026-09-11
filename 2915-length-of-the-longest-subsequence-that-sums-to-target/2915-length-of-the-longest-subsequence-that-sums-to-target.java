class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n=nums.size();
        int[][] dp=new int[n][target+1];

        for(int j=1;j<target+1;j++){
            if(j==nums.get(0) && dp[0][j-nums.get(0)]!=-1){
                dp[0][j]=1+dp[0][j-nums.get(0)];
            }
            else{
                dp[0][j]=-1;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<target+1;j++){
                int temp=dp[i-1][j];
                if(j>=nums.get(i)){
                    if(dp[i-1][j-nums.get(i)]!=-1)
                    temp=Math.max(temp, 1+dp[i-1][j-nums.get(i)]);
                    
                }
                dp[i][j]=temp;
            }
        }

        return dp[n-1][target];
        
    }
}