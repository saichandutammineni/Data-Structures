class TimeMap {
    class Pair{
        int time;
        String val;

        Pair(int time, String val){
            this.time=time;
            this.val=val;
        }
    }
    private HashMap<String, List<Pair>> hm;

    public TimeMap() {
        hm=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(hm.containsKey(key)){
            hm.get(key).add(new Pair(timestamp, value));
        }
        else{
            List<Pair> ll=new ArrayList<>();
            ll.add(new Pair(timestamp, value));
            hm.put(key, ll);
        }
    }

    private int findLower(List<Pair> ll, int target){
        int l=0, r=ll.size();
        while(l<r){
            int mid=l+(r-l)/2;
            if(ll.get(mid).time<=target){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l-1;
    }
    
    public String get(String key, int timestamp) {
        if(hm.containsKey(key) && hm.get(key).size()>0){
            int index=findLower(hm.get(key), timestamp);
            return index==-1 ? "" : hm.get(key).get(index).val;
        }
        else{
            return "";
        }
    }

    
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */