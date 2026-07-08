class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b)-> Integer.compare(a[1], b[1]));
        int[][] sortedEnd=trips.clone();
        
        Arrays.sort(sortedEnd, (a,b)-> Integer.compare(a[2], b[2]));
        int j=0, curr=0;
        for(int i=0;i<trips.length;i++){
            while(j<trips.length && (sortedEnd[j][2]<=trips[i][1])){
                curr-=sortedEnd[j++][0];
            }

            curr+=trips[i][0];
            //System.out.println(curr);
            if(curr>capacity){
                return false;
            }
        }
        return true;
    }
}