class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<String> ar=new ArrayDeque<String>();

        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("*") || tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/")){
                int a=Integer.valueOf(ar.removeFirst());
                int b=Integer.valueOf(ar.removeFirst());
                switch (tokens[i]) {
                    case "*":
                        a=b*a;
                        break;
                    case "+":
                        a=b+a;
                        break;
                    case "-":
                        a=b-a;
                        break;
                    case "/":
                        a=b/a;
                        break;
                    
                }
                ar.addFirst(a+"");
            }
            else{
                ar.addFirst(tokens[i]);
            }
        }

        return Integer.valueOf(ar.removeFirst());
    }
}