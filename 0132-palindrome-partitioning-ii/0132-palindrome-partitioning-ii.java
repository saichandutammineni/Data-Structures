class Solution {
    private int solve(boolean[][] isPal, String s, int l, int r, Integer[][] dp){
        if(l==r) return 0;
        if(l>r) return -1;
        if(dp[l][r]!=null) return dp[l][r];

        int temp=Integer.MAX_VALUE;
        for(int i=l;i<=r;i++){
            if(isPal[l][i]){
                temp=Math.min(temp, 1+solve(isPal, s, i+1, r, dp));
            }
            
        }

        return dp[l][r]=temp==Integer.MAX_VALUE ? 0 : temp;
    }
    public int minCut(String s) {
        int n=s.length();
        boolean[][] isPal=new boolean[n][n];

        for(int i=0;i<n;i++){
            int l=i, r=i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                isPal[l][r]=true;
                l--;
                r++;
            }

            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                isPal[l][r]=true;
                l--;
                r++;
            }
        }

        Integer[][] dp=new Integer[n][n];
        return solve(isPal, s, 0, n-1, dp);
    }
}