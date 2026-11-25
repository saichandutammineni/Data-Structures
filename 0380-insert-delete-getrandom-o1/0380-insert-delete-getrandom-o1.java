class RandomizedSet {
    private Map<Integer, Integer> hm;
    private List<Integer> list;
    Random rd=new Random();

    public RandomizedSet() {
        hm=new HashMap<>();
        list=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val)){

           return false; 
        }
        else{
            
            hm.put(val, list.size());
            list.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(hm.containsKey(val)){
            int valIndex=hm.get(val);
            hm.remove(val);
            if(list.size()-1!=valIndex){
            int lastVal=list.get(list.size()-1);
            hm.put(lastVal , valIndex);
            list.set(valIndex, lastVal);
            }

            list.remove(list.size()-1);
           return true; 
        }
        else{
            return false;
        }
    }
    
    public int getRandom() {
        return list.get(rd.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */