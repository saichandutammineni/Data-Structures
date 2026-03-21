class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products, ((a,b)-> a.compareTo(b)));
        List<List<String>> res=new ArrayList<>();
        char[] arr=searchWord.toCharArray();
        for(int i=0;i<arr.length;i++){
            String curr=searchWord.substring(0, i+1);
            int l=0, r=products.length-1;
            while(l<=r){
                int m=l+(r-l)/2;
                if(products[m].startsWith(curr) && (m==0 || (m>0 && !products[m-1].startsWith(curr)))){
                    int temp=3;
                    List<String> ll=new ArrayList<>(temp);
                    while(temp-->0 && m<products.length && products[m].startsWith(curr)){
                        ll.add(products[m++]);
                    }
                    res.add(ll);
                    break;

                }
                else if(products[m].compareTo(curr)>0){
                    r=m-1;
                }
                else{
                    l=m+1;
                }
            }
            if(res.size()!=i+1){
                res.add(new ArrayList<>());
            }
        }
        return res;
    }
}