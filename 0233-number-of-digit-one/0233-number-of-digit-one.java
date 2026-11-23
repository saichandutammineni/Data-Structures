class Solution {
    public int countDigitOne(int n) {
         int factor=1, count=0;

         while(factor<=n){
            int high=n/(factor*10);
            int curr=(n / factor)% 10;
            int low=n%factor;

            if(curr==0){
                count+=high * factor;
            }
            else if(curr==1){
                count+=high* factor + low+1;
            }
            else{
                count+=(high+1)*factor;
            }

            factor*=10;
         }
         return count;
    }
}