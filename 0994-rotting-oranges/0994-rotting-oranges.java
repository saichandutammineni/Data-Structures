class Solution {
    class Node{
        int i;
        int j;

        Node(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public int orangesRotting(int[][] grid) {
        int count=0, m=grid.length, n=grid[0].length;
        ArrayDeque<Node> q=new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    count++;
                }
                else if(grid[i][j]==2){
                    Node node=new Node(i, j);
                    q.addLast(node);
                }
            }
        }
        int pathLength=-1;
        while(!q.isEmpty()){
            int currSize=q.size();
            pathLength++;
            while(currSize-->0){
                Node temp=q.poll();
                

                if(temp.i>0 && grid[temp.i-1][temp.j]==1){
                    grid[temp.i-1][temp.j]=2;
                    count--;
                    q.addLast(new Node(temp.i-1, temp.j));
                }
                if(temp.i<m-1 && grid[temp.i+1][temp.j]==1){
                    grid[temp.i+1][temp.j]=2;
                    count--;
                    q.addLast(new Node(temp.i+1, temp.j));
                }
                if(temp.j>0 && grid[temp.i][temp.j-1]==1){
                    grid[temp.i][temp.j-1]=2;
                    count--;
                    q.addLast(new Node(temp.i, temp.j-1));
                }
                if(temp.j<n-1 && grid[temp.i][temp.j+1]==1){
                    grid[temp.i][temp.j+1]=2;
                    count--;
                    q.addLast(new Node(temp.i, temp.j+1));
                }
            }
        }

        if(count>0){
            return -1;
        }
        else{
            return Math.max(0, pathLength);
        }
    }
}