class Solution {
    public int maxMoves(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[][] dp=new int[m][n];
        
        for(int j=1;j<2;j++){
            boolean foundNext=false;
            for(int i=0;i<m;i++){
                int temp=0;
                if(i-1>=0 && grid[i-1][j-1]<grid[i][j]) temp=Math.max(dp[i-1][j-1]+1, temp);
                if(grid[i][j-1]<grid[i][j]) temp=Math.max(dp[i][j-1]+1, temp);
                if(i+1<m && grid[i+1][j-1]<grid[i][j]) temp=Math.max(dp[i+1][j-1]+1, temp);
                dp[i][j]=temp;
                if(temp>0) foundNext=true;
            }
            if(!foundNext) return 0;
        }

        for(int j=2;j<n;j++){
            boolean foundNext=false;
            for(int i=0;i<m;i++){
                int temp=0;

                if(i-1>=0 && grid[i-1][j-1]<grid[i][j] && dp[i-1][j-1]>0){
                    temp=Math.max(dp[i-1][j-1]+1, temp);
                    foundNext=true;
                } 
                if(grid[i][j-1]<grid[i][j] && dp[i][j-1]>0){
                    temp=Math.max(dp[i][j-1]+1, temp);
                    foundNext=true;
                } 
                if(i+1<m && grid[i+1][j-1]<grid[i][j] && dp[i+1][j-1]>0){
                    temp=Math.max(dp[i+1][j-1]+1, temp);
                    foundNext=true;
                }
                dp[i][j]=temp;
            }
            if(!foundNext){
                return j-1;
            }
        }
        int res=0;
        for(int i=0;i<m;i++){
            res=Math.max(res, dp[i][n-1]);
        }
        return res;
    }
}