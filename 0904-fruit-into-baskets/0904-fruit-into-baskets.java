class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length<3) return fruits.length;
        int i=0, j=0, max=0;
        HashMap<Integer, Integer> hm=new HashMap<>();
        while(j<fruits.length){
            if(!hm.containsKey(fruits[j])){
                if(hm.size()==2){
                    int min=0, minVal=Integer.MAX_VALUE;
                    for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
                        if(entry.getValue()<minVal){
                            minVal=entry.getValue();
                            min=entry.getKey();
                        }
                    }
                    hm.remove(min);
                    max=Math.max(max, j-i);
                    i=minVal+1;
                }
                
                hm.put(fruits[j], j);
            }
            else{
                hm.put(fruits[j], j);
                
            }
            j++;
        }
        return Math.max(max, j-i);
    }
}