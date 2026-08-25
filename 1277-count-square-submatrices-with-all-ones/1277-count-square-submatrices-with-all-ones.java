class Solution {
    private int solve(int[][] mat, int[][] dp, int x, int y){
        if(x>=mat.length || y>=mat[0].length) return 0;
        if(dp[x][y]!=-1) return dp[x][y];

        
        // if(mat[x][y]==0){
        //     return dp[x][y]=0;
        // }
        // else{
            return dp[x][y]=1+Math.min(solve(mat, dp, x+1, y), Math.min(solve(mat, dp, x, y+1), solve(mat, dp, x+1, y+1)));
        // }
        
    }
    public int countSquares(int[][] matrix) {
        int[][] dp=new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0) dp[i][j]=0;
                else dp[i][j]=-1;
            }
            
        }

        
        int res=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                
                res+=solve(matrix, dp, i, j);
            }
        }
        return res;
    }
}