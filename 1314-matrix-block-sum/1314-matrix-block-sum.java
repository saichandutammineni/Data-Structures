class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m=mat.length, n=mat[0].length, pf=0; // prefixSum
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = mat[i][j]+ (i > 0 ? dp[i-1][j] : 0)+(j > 0 ? dp[i][j-1] : 0)
                - (i > 0 && j > 0 ? dp[i-1][j-1] : 0);
            }
        }

        int[][] res=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int i_r=Math.min(i+k,m-1);
                int i_l=i-k-1;
                int j_down=Math.min(j+k , n-1);
                int j_up=j-k-1;

                res[i][j]=dp[i_r][j_down];
                if(i_l>=0){
                    res[i][j]-=dp[i_l][j_down];
                }
                if(j_up>=0){
                    res[i][j]-=dp[i_r][j_up];
                }
                if(i_l>=0 && j_up>=0){
                    res[i][j]+=dp[i_l][j_up];
                }
                

            }
        }
        return res;
    }
}