class Solution {
    int[][] dirs={{1,2}, {2,1}, {-1,2}, {-2,1}, {-2,-1}, {-1,-2}, {1,-2}, {2,-1}};
    
    private double solve(Double[][][] dp, int r, int c, int k){
        if(r<0 || r>=dp.length || c<0 || c>=dp.length) return 0;
        if(k==0) return 1;
        if(dp[r][c][k]!=null) return dp[r][c][k];

        double temp=0;
        for(int i=0;i<dirs.length;i++){
            temp+=(0.125 * (solve(dp, r+dirs[i][0], c+dirs[i][1], k-1)));
        }
        return dp[r][c][k]=temp;
    }

    public double knightProbability(int n, int k, int row, int column) {
        
        Double[][][] dp=new Double[n][n][k+1];
        return solve(dp, row, column, k);
    }
}