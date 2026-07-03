class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length, count=0;
        int[] cand=new int[n];
        Arrays.fill(cand, 1);

        // left to right while right is not yet fixed
        for(int i=1;i<n;i++){
            if(ratings[i-1]<ratings[i]){
                cand[i]=cand[i-1]+1;
            }
        }

        // right to left
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                cand[i]=Math.max(cand[i], cand[i+1]+1);
                
            }
            count+=cand[i];
        }

        return count+cand[n-1];
    }
}