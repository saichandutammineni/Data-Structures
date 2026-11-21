class Solution {
    private int solve(Integer[][] dp, int target, int index, int[] stones){
        if(index==stones.length){
            return 0;
        }
        if(dp[target][index]!=null){
            return dp[target][index];
        }

        int skip=solve(dp, target, index+1, stones);
        
        if(stones[index]<=target){
            skip=Math.max(skip, stones[index]+solve(dp, target-stones[index], index+1, stones));
        }

        return dp[target][index]=skip;

    }
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int i:stones)
            sum+=i;

        int target=sum/2; // this can be double, but not required
        Integer[][] dp=new Integer[target+1][stones.length];

        int s1=solve(dp, target, 0, stones); 
        return sum-2*s1;
    }
}