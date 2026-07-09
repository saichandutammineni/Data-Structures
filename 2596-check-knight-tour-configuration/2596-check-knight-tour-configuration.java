class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int num=0,n=grid.length, x=0, y=0;
        int[][] dirs={{2,1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1,2}};
        if(grid[0][0]!=0) return false;
        while(num<(n*n-1)){
            boolean found=false;
            for(int[] arr:dirs){
                if(x+arr[0]<n && x+arr[0]>=0 && y+arr[1]>=0 && y+arr[1]<n && grid[x+arr[0]][y+arr[1]]==num+1){
                    x=x+arr[0];
                    y=y+arr[1];
                    found=true;
                    break;
                }
                
            }

            if(found){
                num++;
            }
            else{
                return false;
            }

            
        }
        return true;
    }
}