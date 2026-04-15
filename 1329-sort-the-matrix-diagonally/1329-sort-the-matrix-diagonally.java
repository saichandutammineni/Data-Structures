class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m=mat.length, n=mat[0].length;
        for(int i=m-1;i>=0;i--){
            int j=0, temp_i=i;

            List<Integer> ll=new ArrayList<>();
            while(temp_i<m && j<n){
                ll.add(mat[temp_i++][j++]);
            }

            Collections.sort(ll);
            temp_i=i;
            j=0;
            int k=0;
            while(temp_i<m && j<n){
                mat[temp_i++][j++]=ll.get(k++);
            }
        }

        for(int j=1;j<n;j++){
            int i=0, temp_j=j;

            List<Integer> ll=new ArrayList<>();
            while(i<m && temp_j<n){
                ll.add(mat[i++][temp_j++]);
            }

            Collections.sort(ll);
            temp_j=j;
            i=0;
            int k=0;
            while(i<m && temp_j<n){
                mat[i++][temp_j++]=ll.get(k++);
            }
        }

        return mat;
    }
}