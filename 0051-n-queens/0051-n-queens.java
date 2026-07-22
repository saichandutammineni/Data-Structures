class Solution {
    private void findWays(List<List<String>> res, HashSet<Integer> md, HashSet<Integer> ad, HashSet<Integer> cols, int x, int y, List<String> ll, StringBuffer sb){
        if(x==sb.length()){
            if(cols.size()==sb.length())
                res.add(new ArrayList<>(ll));
            return;
        }
        
        
        if((!cols.contains(y) && !md.contains(x-y) && !ad.contains(x+y))){
            cols.add(y);
            ad.add(x+y);
            md.add(x-y);
            sb.setCharAt(y, 'Q');
            ll.add(sb.toString());
            sb.setCharAt(y, '.');
            
            findWays(res, md, ad, cols, x+1, 0, ll, sb);
            
            cols.remove(y);
            ll.remove(ll.size()-1);
            ad.remove(x+y);
            md.remove(x-y);
          
            
        }

        if(y!=sb.length()-1){
            findWays(res, md, ad, cols, x, y+1, ll, sb);
        }
        else{
            findWays(res, md, ad, cols, x+1, 0, ll, sb);
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        HashSet<Integer> md=new HashSet<>();  // main diagonal
        HashSet<Integer> ad=new HashSet<>(); 
        HashSet<Integer> cols=new HashSet<>();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<n;i++){
            sb.append('.');
        }
        List<String> ll=new ArrayList<>();
        findWays(res, md, ad, cols, 0, 0, ll, sb);
        return res;
    }
}