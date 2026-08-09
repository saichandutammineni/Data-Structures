class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp=new int[2][n];
        

        for(int i=0;i<n;i++){
            dp[0][i]=matrix[0][i];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                dp[1][j]=(j>0 ? Math.min(dp[0][j], dp[0][j-1]) : dp[0][j])+matrix[i][j];
                if(j<n-1 && dp[1][j]>dp[0][j+1]+matrix[i][j]){
                    dp[1][j]=dp[0][j+1]+matrix[i][j];
                }

                
            }
            //dp[0]=dp[1];
            for(int k=0;k<n;k++){
                dp[0][k]=dp[1][k];
            }
        }
        int ans=dp[0][0];
        for(int i=1;i<n;i++){
            ans=Math.min(ans, dp[0][i]);
        }
        return ans;
    }
}