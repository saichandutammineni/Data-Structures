class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length, n=mat[0].length, i=0, j=0;
        int[] res=new int[m*n];
        int k=0;
        boolean dir=true; // means up
        while(true){
            // check incrementing in direction
            res[k++]=mat[i][j];
            if(dir){
                
                if(i-1>=0 && j+1<n){
                    i-=1;
                    j+=1;
                }
                else{
                    // else change direction
                    if(j+1<n){
                        j+=1;
                        dir=false;
                    }
                    else if(i+1<m){
                        i+=1;
                        dir=false;
                    }
                    else{
                        break;
                    }

                }

            }
            else{
                if(i+1<m && j-1>=0){
                    i=i+1;
                    j=j-1;
                }
                else{
                    if(i+1<m){
                        i+=1;
                        dir=true;
                    }
                    else if(j+1<n){
                        j+=1;
                        dir=true;
                    }
                    else{
                        break;
                    }
                }
            }

            
        }

        return res;
    }
}