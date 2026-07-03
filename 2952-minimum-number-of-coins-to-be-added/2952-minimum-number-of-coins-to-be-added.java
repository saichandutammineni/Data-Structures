class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);

        int obt=1, i=0, count=0, cumm=0; // https://www.youtube.com/watch?v=DQM_CfD4iJk
        while(obt<=target){
            if(i<coins.length && coins[i]<=obt){
                cumm+=coins[i];
                obt=cumm+1;
                i++;
            }
            else{
                count++;
                cumm+=obt;
                obt=cumm+1;
            }
        }
        return count;
    }
}