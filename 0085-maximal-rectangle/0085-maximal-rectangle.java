class Pair{
    int index;
    int height;

    Pair(int index, int height){
        this.index=index;
        this.height=height;
    }
}

class Solution {
    
    private int lhist(int[] arr){
        int ans=0;
        ArrayDeque<Pair> dq=new ArrayDeque<>();
        dq.addLast(new Pair(0, arr[0]));

        for(int i=1;i<arr.length;i++){
            int lastIndex=-1;
            while(!dq.isEmpty() && dq.peekLast().height>arr[i]){
                lastIndex=dq.peekLast().index;
                ans=Math.max(ans, (i-lastIndex) *dq.peekLast().height );
                dq.pollLast();
            }
            if(lastIndex==-1){
                dq.addLast(new Pair(i, arr[i]));
            }
            else{
                dq.addLast(new Pair(lastIndex, arr[i]));
            }

        }

        while(!dq.isEmpty()){
            ans=Math.max(ans, dq.peekLast().height*(arr.length-dq.peekLast().index));
            dq.pollLast();
        }
        return ans;
    }
    public int maximalRectangle(char[][] matrix) {
        int ans=0, m=matrix.length, n=matrix[0].length;

        int[][] pf=new int[m][n];
        for(int i=0;i<n;i++){
            pf[0][i]=matrix[0][i]=='1'? 1 : 0;
        }

        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    pf[i][j]=pf[i-1][j]+1;
                }
            }
        }

        for(int i=0;i<m;i++){
            ans=Math.max(ans, lhist(pf[i]));
        }
        return ans;
    }
}