class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> ar=new ArrayDeque<Integer>();

        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("*") || tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/")){
                int a=ar.removeFirst();
                int b=ar.removeFirst();
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
                ar.addFirst(a);
            }
            else{
                ar.addFirst(Integer.valueOf(tokens[i]));
            }
        }

        return ar.removeFirst();
    }
}