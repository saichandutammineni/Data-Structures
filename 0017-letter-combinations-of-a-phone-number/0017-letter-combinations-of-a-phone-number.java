class Solution {
    private String getLetters(char num){
        switch (num) {
    case '2': return "abc";
    case '3': return "def";
    case '4': return "ghi";
    case '5': return "jkl";
    case '6': return "mno";
    case '7': return "pqrs";
    case '8': return "tuv";
    case '9': return "wxyz";
    default: return "";
}
    }

    private void getCombs(List<String> res, String digits, StringBuilder sb){
        if(sb.length()==digits.length()){
            res.add(sb.toString());
            return;
        }

        String str=getLetters(digits.charAt(sb.length()));
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            getCombs(res, digits, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder("");
        getCombs(res, digits, sb);
        return res;
    }
}