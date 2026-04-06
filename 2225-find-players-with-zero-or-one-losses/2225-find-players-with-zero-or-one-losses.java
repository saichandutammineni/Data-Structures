class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] lossCount=new int[100001];

        for(int i=0;i<matches.length;i++){
            if(lossCount[matches[i][0]]==0)
            lossCount[matches[i][0]]=-1;

            if(lossCount[matches[i][1]]==-1)
                lossCount[matches[i][1]]=1;
            
            else
                lossCount[matches[i][1]]++;
        }

        List<Integer> noLoss=new ArrayList<>();
        List<Integer> oneLoss=new ArrayList<>();

        for(int i=0;i<lossCount.length;i++){
            if(lossCount[i]==-1) noLoss.add(i);
            if(lossCount[i]==1) oneLoss.add(i);
        }
        List<List<Integer>> res=new ArrayList<>(2);
        res.add(noLoss);
        res.add(oneLoss);
        return res;
    }
}