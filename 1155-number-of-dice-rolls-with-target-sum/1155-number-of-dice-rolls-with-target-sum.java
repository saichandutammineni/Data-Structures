class Solution {
    long mod=1000000007;
    private long solve(int n, int k, int target, int dice, int curr, Integer[][] dp){
        if(dice==n){
            if(curr==target){
                return 1;
            }
            else return 0;
        }

        if(dp[dice][curr]!=null){
            return dp[dice][curr];
        }

        long temp=0;
        for(int i=1;i<=k;i++){
            if(curr+i<=target){
                temp=(temp+solve(n, k, target, dice+1, curr+i, dp))%mod;
            }
            
        }
        return dp[dice][curr]=(int)temp;
    }

    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] dp=new Integer[n][target+1];

        return (int)solve(n, k, target, 0, 0, dp);
    }
}