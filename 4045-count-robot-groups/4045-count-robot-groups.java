class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int group=1, n=position.length, currPos=n-1;

        for(int i=n-2;i>=0;i--){
            if(speed[currPos]<speed[i] || position[i+1]-position[i]<=distance){
                continue;
            }

            group++;
            currPos=i;

        }

        return group;
    }
}