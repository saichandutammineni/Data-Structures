class Solution {

    private boolean dfs(String word, int index, char[][] board, int i, int j){
        if(index==word.length()) return true;
        if(i>0 && board[i-1][j]==word.charAt(index)){
            char temp=board[i-1][j];
            board[i-1][j]='&';
            if(dfs(word, index+1, board, i-1, j)) return true;
            else board[i-1][j]=temp;
        }
        if(j>0 && board[i][j-1]==word.charAt(index)){
            char temp=board[i][j-1];
            board[i][j-1]='&';
            if(dfs(word, index+1, board, i, j-1)) return true;
            else board[i][j-1]=temp;
        }
        if(i<board.length-1 && board[i+1][j]==word.charAt(index)){
            char temp=board[i+1][j];
            board[i+1][j]='&';
            if(dfs(word, index+1, board, i+1, j)) return true;
            else board[i+1][j]=temp;
        }
        if(j<board[0].length-1 && board[i][j+1]==word.charAt(index)){
            char temp=board[i][j+1];
            board[i][j+1]='&';
            if(dfs(word, index+1, board, i, j+1)) return true;
            else board[i][j+1]=temp;
        }

        return false;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0)==board[i][j]){
                    char temp=board[i][j];
                    board[i][j]='&';
                    if(dfs(word, 1, board, i, j)) return true;
                    board[i][j]=temp;
                }
            }
        }
        return false;
    }
}