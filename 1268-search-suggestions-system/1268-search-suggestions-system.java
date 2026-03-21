class TrieNode{
    boolean isEnd;
    TrieNode[] next;
    List<String> ll;

    public TrieNode(){
        this.isEnd=false;
        this.next=new TrieNode[26];
        this.ll=new ArrayList<>(3);
    }

}



class Solution {

    private void insert(String s, TrieNode tr){
        TrieNode ptr=tr;
        for(int i=0;i<s.length();i++){
            if(ptr.next[s.charAt(i)-'a']==null){
                ptr.next[s.charAt(i)-'a']=new TrieNode(); 
            }

            ptr=ptr.next[s.charAt(i)-'a'];
            if(ptr.ll.size()<3){
                ptr.ll.add(s);
            }
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res=new ArrayList<>();
        TrieNode tr=new TrieNode();
        for(String s: products){
            insert(s, tr);
        }
        TrieNode temp=tr;
        for(int i=0;i<searchWord.length();i++){
            if(temp.next[searchWord.charAt(i)-'a']!=null){
            res.add(temp.next[searchWord.charAt(i)-'a'].ll);
            temp=temp.next[searchWord.charAt(i)-'a'];
            }
            else{
                break;
            }
        }
        while(res.size()<searchWord.length()){
            res.add(new ArrayList<>());
        }
        
        return res;
    }
}