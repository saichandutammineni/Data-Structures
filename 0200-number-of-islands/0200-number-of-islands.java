class Solution {
    private boolean union(int id1, int id2, int[] parent, int[] rank){
        int p1=findParent(id1, parent);
        int p2=findParent(id2, parent);
        if(p1==p2) return false;
        else if(rank[p1]<rank[p2]){
            parent[p1]=p2;
        }
        else if(rank[p2]<rank[p1]){
            parent[p2]=p1;
        }
        else{
            parent[p2]=p1;
            rank[p1]++;
        }
        return true;
    }

    private int findParent(int id, int[] parent){
        if(id!=parent[id]){
            parent[id]=findParent(parent[id], parent);
        }
        return parent[id];
    }


    public int numIslands(char[][] grid) {
        int m=grid.length, n=grid[0].length, count=0;
        int[] parent=new int[m*n];
        int[] rank=new int[m*n];
        //initailizing parent, rank
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int idx=i*n+j;
                if(grid[i][j]=='1'){
                    count++;
                    parent[idx]=idx;
                }
                else{
                    parent[idx]=-1; // water or 0
                }
                rank[idx]=0;
            }
        }

        int[][] dirs=new int[][]{{0,1}, {1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                int idx=i*n+j;
                for(int[] dir: dirs){
                    int ni=i+dir[0];
                    int nj=j+dir[1];
                    if(ni<m && nj<n && grid[ni][nj]=='1'){
                        int idx2=ni * n+nj;
                        if(union(idx, idx2, parent, rank)){
                            count--;
                        }
                    }
                }
                }
            }
        }
        return count;

    }
}