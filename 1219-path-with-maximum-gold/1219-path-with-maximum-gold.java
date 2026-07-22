class Solution {
    int res=0;

    private void findWays(int[][] grid, int x, int y, int gold){

        gold+=grid[x][y];
        boolean isEnd=true;
        int temp=grid[x][y];
        int[][] arr={{1,0}, {0,1}, {-1,0}, {0, -1}};
        for(int i=0;i<arr.length;i++){
            
            if(x+arr[i][0]>=0 && x+arr[i][0]<grid.length && y+arr[i][1]>=0 && y+arr[i][1]<grid[0].length && grid[x+arr[i][0]][y+arr[i][1]]!=0){
                grid[x][y]=0;
                findWays(grid, x+arr[i][0], y+arr[i][1], gold);
                grid[x][y]=temp;
                isEnd=false;
            }
        }

        if(isEnd && gold>res){
            res=gold;
        }
    }
    public int getMaximumGold(int[][] grid) {
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0)
                    findWays(grid, i, j, 0);
            }
        }
        return res;
    }
}