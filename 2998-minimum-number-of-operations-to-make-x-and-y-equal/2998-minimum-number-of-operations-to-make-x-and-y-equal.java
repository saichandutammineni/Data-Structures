class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if(x==y) return 0;
        int res=Math.abs(x-y);
        if(x<y) return res;
        else{
            
            res=Math.min(res, 5-x%5 + 1+ minimumOperationsToMakeEqual(x/5+1, y));
            res=Math.min(res, x%5 +1 + minimumOperationsToMakeEqual(x/5, y));
            res=Math.min(res, 11-x%11 + 1+ minimumOperationsToMakeEqual(x/11+1, y));
            res=Math.min(res, x%11 +1 + minimumOperationsToMakeEqual(x/11, y));
            return res;
        }
    }
}