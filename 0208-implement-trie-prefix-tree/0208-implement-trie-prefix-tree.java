class Node{
    //char ch;
    Node[] next;
    boolean isEnd;

    Node(){
       // this.ch=ch;
        this.isEnd=false;
        this.next=new Node[26];
    }
}


class Trie {
    Node tr;
    public Trie() {
        tr=new Node();
    }
    
    public void insert(String word) {
        Node ptr=tr;
        for(char c: word.toCharArray()){
            if(ptr.next[c-'a']==null){
                ptr.next[c-'a']=new Node();
            }
            ptr=ptr.next[c-'a'];
        }
        ptr.isEnd=true;
    }
    
    public boolean search(String word) {
        Node ptr=tr;
        for(char c: word.toCharArray()){
            if(ptr.next[c-'a']!=null){
            ptr=ptr.next[c-'a'];
            }
            else{
                return false;
            }
        }
        return ptr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node ptr=tr;
        for(char c: prefix.toCharArray()){
            if(ptr.next[c-'a']!=null){
            ptr=ptr.next[c-'a'];
            }
            else{
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */