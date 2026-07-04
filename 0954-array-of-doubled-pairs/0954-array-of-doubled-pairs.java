class Solution {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> hm=new HashMap<>();
        for(int i: arr){
            hm.put(i, hm.getOrDefault(i,0)+1);
        }

        List<Integer> keyList=new ArrayList<Integer>(hm.keySet());
        Collections.sort(keyList, (a,b)->{return Integer.compare(Math.abs(a), Math.abs(b));} );

        for(int i: keyList){
            int count=hm.get(i);
            if(count==0) continue;

            int pairCount=hm.getOrDefault(2*i, 0);

            if(pairCount<count) return false;

            hm.put(2*i, pairCount-count);
        }
        return true;
    }
}