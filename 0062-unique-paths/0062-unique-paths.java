class Solution {
    private int solve(int[][] dp, int x, int y, int m, int n){
        if(x==m-1 && y==n-1) return 1;
        if(x>m-1) return 0;
        if(y>n-1) return 0;

        if(dp[x][y]!=-1) return dp[x][y];
        return dp[x][y]=solve(dp, x+1, y, m, n)+solve(dp, x, y+1, m, n);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(dp, 0, 0, m, n);
    }
}