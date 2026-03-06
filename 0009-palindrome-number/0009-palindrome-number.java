class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }

        int x1=x, y1=0;

        while(x1!=0){
            int t=x1%10;
            x1=x1/10;

            y1=y1*10+t;
        }

        return x==y1;
    }
}