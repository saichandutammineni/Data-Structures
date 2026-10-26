class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int res=1;

        if(n>=1) res+=9;
        if(n>=2) res+=81;
        int j=2, curr=81;
        for(int i=3;i<=n;i++){
            
            while(j<i){
                curr*=(9-(++j-2));
            }
            res+=curr;
        }
        return res;
    }
}