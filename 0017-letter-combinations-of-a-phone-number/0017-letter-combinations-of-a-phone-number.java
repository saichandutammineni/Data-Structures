class Solution {
    private String getChars(char num){
        switch(num){
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

    private void getCombs(List<String> res, StringBuilder sb, String digits, int index){
        if(digits.length()==index){
            res.add(new String(sb));
            return;
        }

        String temp=getChars(digits.charAt(index));
        for(int i=0;i<temp.length();i++){
            sb.append(temp.charAt(i));
            getCombs(res, sb, digits, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        getCombs(res, sb, digits, 0);
        return res;
    }
}