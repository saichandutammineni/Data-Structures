class Solution {
    public int distMoney(int money, int children) {
        if(money<children) return -1;
        int count=0;
        // give 1 dollar to each child, satisfies req 2
        money-=children;
        // give 7 dollars to max. children possible
        while(money>=7 && children>0){
            money-=7;
            count++;
            children--;
        }

        
        if(money==3 && children==1){
            // case to handle: if only 1 child left and 3 dollars of money left
            count--;
        }
        else if(money>0 && children==0){
            // give leftover money to any one child
            count--;
        }
        return count;
    }
}