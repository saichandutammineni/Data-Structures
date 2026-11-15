
class Solution {
    private int solve(Integer[][] dp, int[] arr, int l, int r){
        if(l>r){
            return 0;
        }
        

        if(dp[l][r]!=null) return dp[l][r];
        int t=0;
        for(int i=l;i<=r;i++){
            t=Math.max(t, arr[l-1]*arr[i]*arr[r+1]+solve(dp, arr, l, i-1)+solve(dp, arr, i+1, r));
        }
        
        return dp[l][r]=t;
    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        int j=1;
        for(int i:nums){
            arr[j++]=i;
        }

        Integer[][] dp=new Integer[n+1][n+1];

        return solve(dp, arr, 1, n);
    }
}