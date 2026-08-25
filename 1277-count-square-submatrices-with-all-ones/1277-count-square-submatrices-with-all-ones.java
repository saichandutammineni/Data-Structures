class Solution {
    
    public int countSquares(int[][] matrix) {
        int[][] dp=new int[matrix.length+1][matrix[0].length+1];

        // for(int i=0;i<matrix.length;i++) dp[i][0]=0;
        // for(int j=0;j<matrix[0].length;j++) dp[0][j]=0;

        int res=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0) dp[i+1][j+1]=0;
                else{
                    dp[i+1][j+1]=1+Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i][j]));
                    res+=dp[i+1][j+1];
                }
            }
        }

        
        
        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[0].length;j++){
                
        //         res+=solve(matrix, dp, i, j);
        //     }
        // }
        return res;
    }
}