class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res=new ArrayList<>();
        Arrays.sort(intervals, (a,b)-> {
            return Integer.compare(a[0], b[0]);
        });
        int l=intervals[0][0], r=intervals[0][1];

        
        for(int i=1;i<intervals.length;i++){
            if(r>=intervals[i][0]){
                r=Math.max(r, intervals[i][1]);
            }
            else{
                res.add(new int[]{l, r});
                l=intervals[i][0];
                r=intervals[i][1];
            }
        }

        res.add(new int[]{l, r});
        return res.toArray(new int[0][]);
    }
}