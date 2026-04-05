class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m=grid.length, n=grid[0].length, prod=1;
        int[][] res=new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[i][j]=prod;
                prod=((prod)*(grid[i][j]%12345))%12345;
            }
        }
        prod=1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1; j>=0;j--){
                res[i][j]=((prod)*(res[i][j]))%12345;
                prod=((prod)*(grid[i][j]%12345))%12345;
            }
        }

        return res;
    }
}