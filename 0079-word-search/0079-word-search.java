class Solution {

    private boolean dfs(String word, int index, char[][] board, int i, int j, HashSet<List<Integer>> hs){
        if(index==word.length()) return true;
        if(i>0 && board[i-1][j]==word.charAt(index) && !hs.contains(List.of(i-1, j))){
            hs.add(List.of(i-1,j));
            if(dfs(word, index+1, board, i-1, j, hs)) return true;
            else hs.remove(List.of(i-1, j));
        }
        if(j>0 && board[i][j-1]==word.charAt(index) && !hs.contains(List.of(i, j-1))){
            hs.add(List.of(i,j-1));
            if(dfs(word, index+1, board, i, j-1, hs)) return true;
            else hs.remove(List.of(i, j-1));
        }
        if(i<board.length-1 && board[i+1][j]==word.charAt(index) && !hs.contains(List.of(i+1, j))){
            hs.add(List.of(i+1,j));
            if(dfs(word, index+1, board, i+1, j, hs)) return true;
            else hs.remove(List.of(i+1, j));
        }
        if(j<board[0].length-1 && board[i][j+1]==word.charAt(index)  && !hs.contains(List.of(i, j+1))){
            hs.add(List.of(i,j+1));
            if(dfs(word, index+1, board, i, j+1, hs)) return true;
            else hs.remove(List.of(i, j+1));
        }

        return false;
    }
    public boolean exist(char[][] board, String word) {
        HashSet<List<Integer>> hs=new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0)==board[i][j]){
                    hs.add(List.of(i,j));
                    if(dfs(word, 1, board, i, j, hs)) return true;
                    hs.remove(List.of(i,j));
                }
            }
        }
        return false;
    }
}