class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        TreeSet<Integer> all=new TreeSet<>();
        TreeSet<Integer> lost=new TreeSet<>();
        HashSet<Integer> lost1More=new HashSet<>();

        for(int i=0;i<matches.length;i++){
            all.add(matches[i][1]);
            all.add(matches[i][0]);

            if(!lost.add(matches[i][1])){
                lost1More.add(matches[i][1]);
            }
        }
        List<List<Integer>> res=new ArrayList<>(2);
        all.removeAll(lost);
        res.add(new ArrayList<>(all));
        lost.removeAll(lost1More);
        res.add(new ArrayList<>(lost));
        return res;
    }
}