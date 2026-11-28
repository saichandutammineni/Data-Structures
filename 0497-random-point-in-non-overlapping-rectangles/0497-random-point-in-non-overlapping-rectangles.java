class Solution {
    int[][] rec;
    List<Long> ll=new ArrayList<>();
    Random rd=new Random();

    private int findMapper(List<Long> cumulatedList, long target){
        int l=0, r=cumulatedList.size();
        while(l<r){
            int mid=(l+r)/2;
            if(cumulatedList.get(mid)>=target){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        // return (l+r)/2;
        return l;
    }
    public Solution(int[][] rects) {
        // rec=new int[rects.length][rects[0].length];
        // for(int i=0;i<rec.length;i++){

        // }
        long sum=0;
        rec=rects.clone();
        for(int i=0;i<rects.length;i++){
            int xcenter=rec[i][2]-rec[i][0];
        int ycenter=rec[i][3]-rec[i][1];
sum+=(long)(xcenter+1) * (ycenter+1);
        ll.add(sum);
        }
    }
    
    public int[] pick() {
        long target=rd.nextLong(ll.get(ll.size()-1))+1;
        int recIndex=findMapper(ll, target);
        //int recIndex=rd.nextInt(rec.length);

        int xcenter=rec[recIndex][2]-rec[recIndex][0];
        int ycenter=rec[recIndex][3]-rec[recIndex][1];

        int ansx=rd.nextInt(xcenter+1)+rec[recIndex][0];
        int ansy=rd.nextInt(ycenter+1)+rec[recIndex][1];
        return new int[]{ansx, ansy};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */