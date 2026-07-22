class Solution {
    private void findWays(List<List<String>> res, HashSet<Integer> md, HashSet<Integer> ad, HashSet<Integer> cols, int x, List<String> ll, StringBuffer sb){
        if(x==sb.length()){
            if(cols.size()==sb.length())
                res.add(new ArrayList<>(ll));
            return;
        }
        
        for(int i=0;i<sb.length();i++){
            if((!cols.contains(i) && !md.contains(x-i) && !ad.contains(x+i))){
                cols.add(i);
                ad.add(x+i);
                md.add(x-i);
                sb.setCharAt(i, 'Q');
                ll.add(sb.toString());
                sb.setCharAt(i, '.');
                
                findWays(res, md, ad, cols, x+1, ll, sb);
                
                cols.remove(i);
                ll.remove(ll.size()-1);
                ad.remove(x+i);
                md.remove(x-i);
            
                
            }
        }

        // if(y!=sb.length()-1){
        //     findWays(res, md, ad, cols, x, y+1, ll, sb);
        // }
        // else{
        //     findWays(res, md, ad, cols, x+1, 0, ll, sb);
        // }
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
        findWays(res, md, ad, cols, 0, ll, sb);
        return res;
    }
}