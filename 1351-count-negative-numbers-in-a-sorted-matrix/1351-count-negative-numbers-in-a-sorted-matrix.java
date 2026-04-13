class Solution {
    public int countNegatives(int[][] grid) {
        int m=grid.length, n=grid[0].length, ptrRow=m-1, ptrCol=0, count=0;

        while(ptrRow>=0 && ptrCol<n){
            if(grid[ptrRow][ptrCol]<0){
                count+=n-ptrCol;
                ptrRow--;
            }
            else{
                ptrCol++;
            }
        }
        return count; 
    }
}