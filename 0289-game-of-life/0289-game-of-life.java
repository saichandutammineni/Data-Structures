class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length, n=board[0].length;
        int[][] prev={{-1,-1}, {-1, 1}, {-1,0}, {0,-1}};
        int[][] next={{0,1}, {1,0}, {1,1}, {1, -1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int cp=0;
                for(int[] p:prev){
                    if(i+p[0]>=0 && i+p[0]<m && j+p[1]>=0 && j+p[1]<n && board[i+p[0]][j+p[1]]/10==1){
                        cp++;
                    }
                }
                
                int cn=0;
                for(int[] p:next){
                    if(i+p[0]>=0 && i+p[0]<m && j+p[1]>=0 && j+p[1]<n && board[i+p[0]][j+p[1]]==1){
                        cn++;
                    }
                }
                
                int count=cp+cn;
                
                if(board[i][j]==1){
                    if(count<2){
                        board[i][j]*=10;
                    }
                    else if(count==2 || count==3){
                        board[i][j]=board[i][j]*10+1;
                    }
                    else{
                        board[i][j]=board[i][j]*10;
                    }
                }
                else if(count==3){
                    board[i][j]=board[i][j]*10+1;
                }
                else{
                    board[i][j]=board[i][j]*10;
                }


            }
        }


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]%=10;
            }
        }
    }
}