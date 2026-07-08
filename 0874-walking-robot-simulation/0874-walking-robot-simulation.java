class Solution {
    private int changeDirs(int len, int curr, int i){
        if(i==-1){
            if(curr+1<len){
                return curr+1;
            }
            else{
                return 0;
            }
        }
        else{
            if(curr-1>=0){
                return curr-1;
            }
            else{
                return len-1;
            }
        }
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dirs={{-1,0}, {0,1}, {1,0}, {0, -1}};

        HashSet<String> obs=new HashSet<>();
        int x=0, y=0, index=1, res=0;
        for(int[] arr: obstacles){
            obs.add(arr[0]+" "+arr[1]);
        }
        
        for(int i:commands){
            if(i<0){
                index=changeDirs(dirs.length, index, i);
            }
            else{
                int x1=dirs[index][0];
                int y1=dirs[index][1];
                int steps=i;
                
                while(steps-->0){
                    int x2=x+x1, y2=y+y1;

                    if(obs.contains(x2+" "+y2))
                        break;
                    
                    x=x2;
                    y=y2;
                }
                
                
                
                res=Math.max(res, x*x+y*y);
            }
        }
        return res;
    }
}