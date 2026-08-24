class Solution {
    private int solve(int[][] dp, int x, int y, int m, int n, int[][] grid){
        if(x>m-1) return 0;
        if(y>n-1) return 0;
        if(grid[x][y]==1) return 0;
        if(x==m-1 && y==n-1) return 1;
        
        

        if(dp[x][y]!=-1) return dp[x][y];
        return dp[x][y]=solve(dp, x+1, y, m, n, grid)+solve(dp, x, y+1, m, n, grid);
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length, n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(dp, 0, 0, m, n, obstacleGrid);
    }
}