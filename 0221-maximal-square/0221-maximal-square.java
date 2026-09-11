class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int[][] dp=new int[m][n];
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]=1;
                    res=1;
                }
                else dp[i][j]=0;
            }
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(dp[i][j]==1){
                    
                    if(dp[i-1][j]>0 && dp[i][j-1]>0 && dp[i-1][j-1]>0){
                        dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))+1;
                    }
                    res=Math.max(res, dp[i][j]);
                }
                
            }
        }
        return res*res;
    }
}