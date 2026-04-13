class Solution {
    private int findRight(int[][] intervals, int l, int r){
        int s=intervals[l][0], e=intervals[l][1];
        while(l<=r){
            int mid=l+(r-l)/2;
            if(intervals[mid][0]>=e && (mid==0 || intervals[mid-1][0]<e)){
                return intervals[mid][0];
            }
            else if(intervals[mid][0]<e){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return Integer.MIN_VALUE;
    }
    public int[] findRightInterval(int[][] intervals) {
        int n=intervals.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(intervals[i][0], i);
        }

        int[] res=new int[n];
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        for(int i=0;i<n;i++){
            int idx=findRight(intervals, i, n-1);
            int resIndex=map.get(intervals[i][0]); // gives actual index of start number in given input. 
            if(idx==Integer.MIN_VALUE){
                res[resIndex]=-1;
            }
            else{
                res[resIndex]=map.get(idx);
            }
        }
        return res;
    }
}