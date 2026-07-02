class Solution {
    public int distMoney(int money, int children) {
        if(money<children) return -1;
        // give 1 dollar to each child, satisfies req 2
        money-=children;
        // give 7 dollars to max. children possible
        int childrenwith8=Math.min(children, money/7);

        //remaining children without 8
        children-=childrenwith8;
        //left money
        money-=(7*childrenwith8);

        
        if(money==3 && children==1){
            // case to handle: if only 1 child left and 3 dollars of money left
            childrenwith8--;
        }
        else if(money>0 && children==0){
            // give leftover money to any one child
            childrenwith8--;
        }
        return childrenwith8;
    }
}