class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> prev=List.of(1);
        res.add(prev);
        numRows--;
        while(numRows-->0){
            List<Integer> curr=new ArrayList<>();
            curr.add(1);
            for(int i=0;i<prev.size()-1;i++){
                curr.add(prev.get(i)+prev.get(i+1));
            }
            curr.add(1);
            res.add(curr);
            prev=curr;
        }

        return res;
    }
}