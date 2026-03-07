class Solution {
    // private char getPartner(char ch){
    //     switch(ch){
    //         case ')': return '(';
    //         case '}': return '{';
    //         case '[': return ']';
    //         default: return '';
    //     }
    // }
    public boolean isValid(String s) {
        ArrayDeque<Character> q=new ArrayDeque<>();
        HashMap<Character, Character> hm=new HashMap<>();
        hm.put(')', '(');
        hm.put('}', '{');
        hm.put(']', '[');

        for(int i=0;i<s.length();i++){
            if(!hm.containsKey(s.charAt(i))){
                q.addFirst(s.charAt(i));
            }
            else{
                if(q.size()==0 || q.removeFirst()!=hm.get(s.charAt(i))){
                    return false;
                }
            }
        }
        return q.size()==0;
    }
}