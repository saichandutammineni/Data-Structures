class Solution {
    public int maxCoins(int[] piles) {
        int ans=0, n=piles.length;
        Arrays.sort(piles);
        for(int i=n-2;i>=n/3;i-=2){
            ans+=piles[i];
        }
        return ans;
    }
}