class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=board.length;
        boolean[][] row=new boolean[n][n];
        boolean[][] col=new boolean[n][n];
        boolean[][] box=new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                
                if(board[i][j]=='.'){
                    continue;
                }
                else{
                    int val=(board[i][j]-'0')-1;
                    if(row[i][val]) return false;
                    row[i][val]=true;

                    if(col[val][j]) return false;
                    col[val][j]=true;

                    int boxNum=3*(i/3)+(j/3);
                    if(box[boxNum][val]) return false;
                    box[boxNum][val]=true;
                }
            }
        }
        return true;
    }
}