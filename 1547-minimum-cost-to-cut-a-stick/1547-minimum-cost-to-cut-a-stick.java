class Solution {
    private int solve(int[] cuts, int l, int r, Integer[][] dp){
        if(l>=r) return 0;

        if(dp[l][r]!=null) return dp[l][r];

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<cuts.length;i++){
            if(cuts[i]>cuts[l] && cuts[i]<cuts[r]){
                int t=cuts[i];
                // cuts[i]=-1;
                ans=Math.min(ans, solve(cuts, l, i, dp)+cuts[r]-cuts[l]+solve(cuts, i, r, dp));

                // cuts[i]=t;
            }
        }
        return dp[l][r]=(ans==Integer.MAX_VALUE ? 0 : ans);
    }
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        Arrays.sort(cuts);
        int[] arr=new int[m+2];
        arr[0]=0;
        arr[m+1]=n;
        int k=0;
        for(int i=1;i<m+1;i++){
            arr[i]=cuts[k++];
        }
        Integer[][] dp=new Integer[m+2][m+2];
        return solve(arr, 0, m+1, dp);
    
    }
}