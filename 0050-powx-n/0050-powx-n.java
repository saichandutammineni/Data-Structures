class Solution {
    private double calc(double x, long n){
        if(n==0){
            return 1;
        }
        else if(n==1){
            return x;
        }
        else if(n%2==0){
            double temp=calc(x, n/2);
            return temp*temp;
        }
        else{
            double temp=calc(x, (n-1)/2);
            return (x*temp)*temp;
        }
    }
    public double myPow(double x, int n) {
        if(x==0 || x==1){
            return x;
        }
        long N=n;
        double res=calc(x, Math.abs(N));
        if(n>0){
            return res;
        }
        return 1/res;
    }
}