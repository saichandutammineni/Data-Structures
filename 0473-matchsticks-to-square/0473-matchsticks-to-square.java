class Solution {
    private boolean match(int[] arr, int index, int top, int down, int left, int right, int side){
        if(top==side && down==side && left==side && right==side){
            return true;
        }

        if(top>side || down>side || left>side || right>side){
            return false;
        }

        boolean ans=false;
        ans|=match(arr, index-1, top+arr[index],down,left,right, side);
        ans|=match(arr, index-1, top,down+arr[index],left,right, side);
        ans|=match(arr, index-1, top,down,left+arr[index],right, side);
        ans|=match(arr, index-1, top,down,left,right+arr[index], side);

        return ans;
    }
    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        for(int i:matchsticks){
            sum+=i;
        }

        if(sum%4!=0) return false;
        int side=sum/4;
        Arrays.sort(matchsticks);
        return match(matchsticks, matchsticks.length-1, 0,0,0,0, side);
    }
}