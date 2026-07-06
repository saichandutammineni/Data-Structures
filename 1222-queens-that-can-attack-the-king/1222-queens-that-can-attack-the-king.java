class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] board=new int[8][8];
        for(int[] q: queens){
            board[q[0]][q[1]]=1;
        }

        int[][] steps = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1,1}, {-1, -1}, {1,-1}, {-1, 1} };
        List<List<Integer>> ans=new ArrayList<>();
        for(int[] step: steps){
            int x=king[0]+step[0], y=king[1]+step[1];

            while(x>=0 && x<8 && y>=0 && y<8){
                

                if(board[x][y]==1){
                    List<Integer> ll=new ArrayList<>(2);
                    ll.add(x);
                    ll.add(y);
                    ans.add(ll);
                    break;
                }
                x+=step[0];
                y+=step[1];
            }
        }
        return ans;
    }
}