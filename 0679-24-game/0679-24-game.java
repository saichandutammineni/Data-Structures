class Solution {
    
    // private boolean solve(int[] cards, HashMap<Float, Integer> hs, float val){
    //     // if(hs.size()==1){
    //     //     // return true;
    //     //     return Math.abs(hs.iterator().next() - val) < 1e-6;
    //     // }

    //     int count = 0;
    //     float last = 0;

    //     for (float x : hs.keySet()) {
    //         count += hs.get(x);
    //         last = x;
    //     }

    //     if (count == 1) {
    //         return Math.abs(last - val) < 1e-6;
    //     }

    //     boolean ans=false;
    //     for(int j=0;j<cards.length;j++){
    //         if(hs.containsKey(cards[j])){
    //         float i=(float)cards[j];
    //         float t=i;
    //         if(hs.get(t)>1)
    //         hs.put(t, hs.get(t)-1);
    //         else{
    //             hs.remove(t);
    //         }
    //         // hs.remove(i);
            
    //         ans|=solve(cards, hs, val-i);
    //         ans|=solve(cards, hs, i-val);
    //         if(i!=0){
    //             ans|=solve(cards, hs, (float)val/i);
    //         }
    //         // ans |= solve(cards, hs, val * i);
    //         if(val!=0){
    //         ans|=solve(cards, hs, (float)i/val);
    //         }
    //         // ans |= solve(cards, hs, val+i);

    //         // hs.add(t);
    //         if(hs.containsKey(t))
    //         hs.put(t, hs.get(t)+1);
    //         else{
    //             hs.put(t, 1);
    //         }
    //         }
    //     }
    //     return ans;
    // } 

    private List<Double> generate(double a, double b){
        List<Double> list=new ArrayList<>();
        list.add(a+b);
        list.add(a-b);
        list.add(b-a);
        list.add(a*b);
        if(b!=0)
        list.add((double)a/b);
        if(a!=0){
            list.add((double)b/a);
        }
        return list;
    }

    private boolean solve(List<Double> list){
        if(list.size()==1){
            return Math.abs(list.get(0)-24) < 1e-6;
        }

        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                List<Double> newList=new ArrayList<>();

                for(int k=0;k<list.size();k++){
                    if(k!=i && k!=j){
                        newList.add(list.get(k));
                    }
                }

                
                List<Double> possibles=generate(list.get(i), list.get(j));
                for(double item:possibles){
                    newList.add(item);
                    if(solve(newList))
                    return true;

                    newList.remove(newList.size()-1);

                }


            }
        }

        return false;
    }
    public boolean judgePoint24(int[] cards) {
        // boolean ans=false;
        // HashMap<Float, Integer> hs=new HashMap<>();
        // for(int i:cards){
        //     float t=(float)i;
        //     if(hs.containsKey(t))
        //     hs.put(t, hs.get(t)+1);
        //     else{
        //         hs.put(t, 1);
        //     }
        // }
        // for(int i:cards){
        //     float t=i;
        //     if(hs.containsKey(t) && hs.get(t)>1)
        //     hs.put(t, hs.get(t)-1);
        //     else{
        //         hs.remove(t);
        //     }
            
        //     // ans |= solve(cards, hs, 24+i);
        //     ans|=solve(cards, hs, 24-i);
        //     ans|=solve(cards, hs, i-24);
        //     // ans |= solve(cards, hs, 24 * i);
        //     if(i!=0)
        //     ans|=solve(cards, hs, (float)24/i);
        //     ans|=solve(cards, hs, (float)i/24);

        //     if(hs.containsKey(t))
        //     hs.put(t, hs.get(t)+1);
        //     else{
        //         hs.put(t, 1);
        //     }
        // }
        // return ans;

        List<Double> list=new ArrayList<>(4);
        for(int i:cards){
            list.add((double)i);
        }

        return solve(list);
    }
}